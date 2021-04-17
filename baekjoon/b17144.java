// 1:37
package CodingTest.baekjoon;
import java.io.*;
import java.util.*;

public class b17144 {
	
	static int[][] board;
	static int R, C, T;
	static List<int[]> pos;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		board = new int[R][C];
		pos = new ArrayList<>();
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<C;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == -1) {
					pos.add(new int[] {i, j});
				}
			}
		}
		
		for(int t=0;t<T;t++) {
			// 1. 미세먼지 확산
			spread();
			//System.out.println(t);
			//for(int[]a:board) System.out.println(Arrays.toString(a));
			// 2. 공기 청정기 작동
			// 위쪽 반시계 순환
			blowUpperside();
			
			// 아래쪽 시계 순환
			blowLowerside();
			// 확인용 
			//System.out.println(t);
			//for(int[]a:board) System.out.println(Arrays.toString(a));
		}
		
		int sum = 0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(board[i][j] == -1) continue;
				sum+=board[i][j];
			}
		}
		System.out.println(sum);
		
	}
	
	public static void spread() {
		// bfs
		Deque<int[]> queue = new ArrayDeque<>();
		int[][] newDust = new int[R][C];
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(board[i][j] > 0) {
					queue.offer(new int[] {i,  j, 0});
				}
			}
		}
		
		int [][]dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			
			
			int spreadCounter = 0;
			int spreadAmount = (int)Math.floor(board[q[0]][q[1]]/5);
			if(spreadAmount == 0) continue;
			
			for(int d=0;d<4;d++) {
				int newR = q[0] + dir[d][0];
				int newC = q[1] + dir[d][1];
				
				if(0<=newR&&newR<R && 0<=newC&&newC<C) {
					if(board[newR][newC] >= 0) {
						newDust[newR][newC] += spreadAmount;
						spreadCounter++;
					}
				}
			}
			
			board[q[0]][q[1]] = board[q[0]][q[1]] - (spreadAmount*spreadCounter);

			//for(int[]a:board) System.out.println(Arrays.toString(a));
			//System.out.println();
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				board[i][j] += newDust[i][j];
			}
		}
	}

	public static void blowUpperside() {
		int[] p = pos.get(0);// 윗부분
		
		// 왼
		for(int i=p[0]-1;i>0;i--) {
			board[i][0] = board[i-1][0];
		}
		
		//위
		for(int i=0;i<C-1;i++) {
			board[0][i] = board[0][i+1];
		}
		
		// 오
		for(int i=0;i<p[0];i++) {
			board[i][C-1] = board[i+1][C-1]; 
		}
		
		//아래
		for(int i=C-1;i>1;i--) {
			board[p[0]][i] = board[p[0]][i-1];
		}
		
		//신선한 공기
		board[p[0]][1] = 0;
		
	}
	
	public static void blowLowerside() {
		int[] p = pos.get(1);// 윗부분
		
		// 왼
		for(int i=p[0]+1;i<R-1;i++) {
			board[i][0] = board[i+1][0];
		}
		// 아래
		for(int i=0;i<C-1;i++) {
			board[R-1][i] = board[R-1][i+1];
		}
		// 우
		for(int i=R-1;i>p[0];i--) {
			board[i][C-1] = board[i-1][C-1];
		}
		
		// 위
		for(int i=C-1;i>1;i--) {
			board[p[0]][i] = board[p[0]][i-1];
		}
		//신선한 공기
		board[p[0]][1] = 0;
		
	}
}

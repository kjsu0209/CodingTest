// 중복순열 + bfs
package CodingTest.swexpert;
import java.util.*;
import java.io.*;
public class t_5656 {

	static int N, W, H;
	
	static int minBlockNum;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = stoi(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = stoi(st.nextToken());
			W = stoi(st.nextToken());
			H = stoi(st.nextToken());
			
			int[][] board = new int[H][W];
			
			for(int i=0;i<H;i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0;j<W;j++) {
					board[i][j] = stoi(st.nextToken());
				}
			}
			
			minBlockNum = Integer.MAX_VALUE;
			permutation(0, board);
			System.out.println("#"+tc+" "+minBlockNum);
		}
		
	}
	
	static void permutation(int cnt, int [][] B) {
		if(cnt == N) {
			// 기저조건
			// 남은 벽돌 개수 계산
			int count = 0;
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(B[i][j] > 0) {
						count++;
					}
				}
			}
			//System.out.println();
			//for(int i=0;i<H;i++) System.out.println(Arrays.toString(B[i]));
			
			minBlockNum = Math.min(count, minBlockNum);
			
			return;
		}
		
		// deepcopy
		for(int i=0;i<W;i++) {
			
			// i에 해당하는 위치에 공 떨어뜨린 후 보드 반환
			int[][] board = popBlock(i, B);
			
			permutation(cnt+1, board);
		}
	}
	
	static int[][] direction = {{-1,0},{0,-1},{1,0},{0,1}};
	
	static int[][] popBlock(int index, int[][]B){
		int[][] board = new int[H][W]; // 새로운 보드판
		boolean[][] blockMark = new boolean[H][W]; // 기존 보드판에서 안 터진 블록 마킹. visited역할
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(B[i][j] > 0) {
					blockMark[i][j] = true;
				}
			}
		}
		
		// bfs로 블록 터뜨리기
		Queue <int[]> queue = new LinkedList<>();
		
		// index 라인에 공 떨어뜨렸을때 오는 첫 번째 블록 큐에 삽입
		for(int i=0;i<H;i++) {
			if(B[i][index] > 0) {
				queue.offer(new int[] {i, index});
				blockMark[i][index] = false;
				break;
			}
		}
		
		while(!queue.isEmpty()) {
			int[] q= queue.poll();
			
			int spread = B[q[0]][q[1]] -1;
			// 상하좌우
			for(int i=0;i<4;i++) {
				int newR = q[0];
				int newC = q[1];
				for(int j=0;j<spread;j++) {
					newR += direction[i][0];
					newC += direction[i][1];
					
					if(0<=newR&&newR<H && 0<=newC && newC<W) {
						if(B[newR][newC] != 0 && blockMark[newR][newC]) {
							queue.offer(new int[] {newR, newC});
							blockMark[newR][newC] = false;
						}
					}
				}
			}
		}
		
		// 중력
		for(int line=0;line<W;line++) {
			int i = H-1;
			for(int h=H-1;h>=0;h--) {
				if(blockMark[h][line]) {
					board[i--][line] = B[h][line];
				}
			}
		}
		
		return board;
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}

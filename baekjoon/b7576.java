// bfs
// 0:20
package CodingTest.baekjoon;
import java.io.*;
import java.util.*;
public class b7576 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
	
		int totalNum = 0; 
		int tomatoNum = 0;
		int[][] board = new int[N][M];
		Deque<int[]> queue = new ArrayDeque<>();
		boolean[][]visit = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st =  new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) {
					queue.offer(new int[] {i, j, 0});
					visit[i][j] = true;
					totalNum++;
				}
				
				if(board[i][j] != -1) {
					tomatoNum++;
				}
			}
		}
		
		int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		int lastDay = 0;
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			
			lastDay = Math.max(lastDay, q[2]);
			
			for(int d=0;d<4;d++) {
				int newR = q[0] + dir[d][0];
				int newC = q[1] + dir[d][1];
			
				if(0<=newR&&newR<N && 0<=newC&&newC<M) {
					if(!visit[newR][newC] && board[newR][newC] == 0) {
						queue.offer(new int[] {newR, newC, q[2]+1});
						visit[newR][newC] = true;
						board[newR][newC] = 1;
						totalNum++;
					}
				}
			}
			
			//for(int[] a: board) System.out.println(Arrays.toString(a));
			//System.out.println();
		}
		
		if(tomatoNum == totalNum) {
			System.out.println(lastDay);
		}
		else {
			System.out.println(-1);
		}
		
	}

}

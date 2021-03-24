// 0: 18
// bfs
package CodingTest.baekjoon;
import java.io.*;
import java.util.*;
public class b2636 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = stoi(st.nextToken())+2;
		int M = stoi(st.nextToken())+2;
		
		int[][] board = new int[N][M];
		int cheezeNum = 0;
		for(int i=1;i<N-1;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1;j<M-1;j++) {
				board[i][j] = stoi(st.nextToken());
				if(board[i][j] == 1) {
					cheezeNum++;
				}
			}
		}
		
		int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		int time = 0;
		int lastRemain = cheezeNum;
		while(cheezeNum > 0) {
			int[][] mark = new int[N][M];
			boolean[][] visited = new boolean[N][M];
			// bfs
			Deque<int[]> queue = new ArrayDeque<>();
			
			queue.offer(new int[] {0, 0}); 
			visited[0][0] = true;
			
			
			while(!queue.isEmpty()) {
				int[] q= queue.poll();
				
				for(int d=0;d<4;d++) {
					int newR = q[0] + dir[d][0];
					int newC = q[1] + dir[d][1];
					  
					if(0<=newR&&newR<N && 0<=newC&&newC<M) {
						 if(board[newR][newC] == 1) {
							 mark[newR][newC] = 1;
							 continue;
						 }else {
							 if(!visited[newR][newC]) {
								 queue.offer(new int[] {newR, newC});
								 visited[newR][newC] = true;
							 }
						 }
					}
				}
			}
			
			lastRemain = cheezeNum;
			
			// 치즈 녹이기
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(mark[i][j] == 1) {
						cheezeNum--;
						board[i][j] = 0;
					}
				}
			}
			
			
			time++;

		}
		
		System.out.println(time);
		System.out.println(lastRemain);
		
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}

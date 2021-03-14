// 0:30
// bfs
package CodingTest.swexpert.d4;
import java.io.*;
import java.util.*;
public class d4_10966 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] board = new int[N][M];
			List<int[]> w = new ArrayList<>();

			final int INF = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				String s = in.readLine();
				for(int j=0;j<M;j++) {
					if(s.charAt(j) == 'W')
						board[i][j] = 0;
					else
						board[i][j] = INF;
					if(board[i][j] == 0)
						w.add(new int[] {i, j});
				}
			}
			
			ArrayDeque <int[]> queue = new ArrayDeque<>();
			int[][] dir = {{-1, 0}, {0, -1}, {1, 0},{0,1}};
			for(int[] l: w)
				queue.offer(new int[] {l[0], l[1], 0});
			int sum = 0;
			while(!queue.isEmpty()) {
				int[] q= queue.poll();
				// 상하좌우 이동
				for(int d=0;d<4;d++) {
					int newR = q[0] + dir[d][0];
					int newC = q[1] + dir[d][1];
					
					if(0<=newR && newR<N && 0<=newC && newC<M) {
						if(board[newR][newC] != 0 && (board[newR][newC] > q[2]+1 || board[newR][newC] == INF)) {
							board[newR][newC] = q[2]+1;
							queue.offer(new int[] {newR, newC, q[2]+1});
						}
					}
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					sum += board[i][j];
				}
			}
			
			
			System.out.println("#"+tc+" "+sum);
		}
		
	}
	
	static int getDist(int[] land, int[] water) {
		return Math.abs(land[0]-water[0]) +Math.abs(land[1]-water[1]); 
	}
	
	

}

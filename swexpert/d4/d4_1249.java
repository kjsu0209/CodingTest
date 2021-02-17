package CodingTest.swexpert.d4;
import java.util.*;
import java.io.*;
public class d4_1249 {
	static boolean[][] visit;
	static int N;
	static int minTime;
	static int[][] direction = {{-1, 0},{1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(in.readLine());
			int[][] area = new int[N][N];
			for(int i=0;i<N;i++) {
				char[] c = in.readLine().toCharArray();
				for(int j=0;j<N;j++) {
					area[i][j] = Integer.parseInt(""+c[j]);
				}
			}
			
			minTime = Integer.MAX_VALUE;
			visit = new boolean[N][N];
			
			// 최소 거리값 저장 (다익스트라)
			int[][] memo = new int[N][N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					memo[i][j] = Integer.MAX_VALUE;
				}
			}
			memo[0][0] = 0;
			//dfs(area, 0, 0, area[0][0]);
			
			// bfs
			Queue <int[]> queue = new LinkedList<>();
			queue.offer(new int[] {0, 0, 0});
			
			while(!queue.isEmpty()) {
				int[] q= queue.poll();
				//System.out.println(Arrays.toString(q));
				if(q[0] == N-1 && q[1] == N-1) {
					minTime = Math.min(minTime, q[2]);
					continue;
				}
				
				
				
				// greedy하게 상하좌우 이동
				for(int i=0;i<4;i++) {
					int newR = direction[i][0] + q[0];
					int newC = direction[i][1] + q[1];
										
					if(0<= newR && newR<N && 0<=newC && newC<N) {
						//System.out.println((q[2]+area[newR][newC])+" " + memo[newR][newC]);
						if(q[2] + area[newR][newC] < memo[newR][newC]) {
							queue.offer(new int[] {newR, newC, q[2]+area[newR][newC]});
							memo[newR][newC] = q[2] + area[newR][newC];
						}
						
					}
				}
			}
		
			
			System.out.println("#"+tc+" "+memo[N-1][N-1]);
		}
	}
	
	static void dfs(int[][] area, int row, int col, int time) {
		if(time >= minTime) return;
		if(row == N-1 && col == N-1) {
			// 도착
			minTime = Math.min(minTime, time);
			return;
		}
		
		// 방문하지 않았으면 상하좌우 이동
		for(int i=0;i<4;i++) {
			int newR = direction[i][0] + row;
			int newC = direction[i][1] + col;
			
			if(0<= newR && newR<N && 0<=newC && newC<N) {
				if(!visit[newR][newC]) {
					visit[newR][newC] = true;
					dfs(area, newR, newC, time+area[newR][newC]);
					visit[newR][newC] = false;
				}
			}
		}
	}

}

// Floyd
package CodingTest.swexpert.d6;
import java.io.*;
import java.util.*;

public class d6_1263 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] adjMatrix = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					adjMatrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] dist = new int[N][N];
			int INF = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) Arrays.fill(dist[i], INF);
			for(int i=0;i<N;i++) dist[i][i] = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(adjMatrix[i][j] == 1) dist[i][j] = 1;
				}
			}
			
			for(int k=0;k<N;k++) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(dist[i][k] == INF || dist[k][j] == INF) continue;
						if(dist[i][j] > dist[i][k] + dist[k][j]) {
							dist[i][j] = dist[i][k] + dist[k][j];
						}
					}
				}
			}
			
			int minDist = INF;
			
			for(int i=0;i<N;i++) {
				int d = 0;
				for(int j=0;j<N;j++) {
					if(dist[i][j] == INF) {
						d = INF;
						break;
					}
					d += dist[i][j];
				}
				
				minDist = Math.min(minDist, d);
			}
			
			System.out.println("#"+tc+" "+minDist);
		}
	}

}

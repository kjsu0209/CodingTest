// 0:55
// bfs + bfs + PriorityQueue
package bj;

import java.util.*;
import java.io.*;

public class b19238 {
	
	public void solution() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] initS = br.readLine().split(" ");
		int N = Integer.parseInt(initS[0]);
		int M = Integer.parseInt(initS[1]);
		int initFuel = Integer.parseInt(initS[2]);
		
		int [][] place = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				place[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		String[] initLoc = br.readLine().split(" ");
		int initR = Integer.parseInt(initLoc[0])-1;
		int initC = Integer.parseInt(initLoc[1])-1;

		int[][] custInfo = new int[M][4];
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<4;j++) {
				custInfo[i][j] = Integer.parseInt(st.nextToken())-1;
			}
			
			place[custInfo[i][0]][custInfo[i][1]] = i+2;
		}
		
		int finished = 0;
		int fuel = initFuel;
		int r = initR;
		int c = initC;
		int[][] dir = {{-1,0}, {0,-1}, {0, 1}, {1, 0}};
		
		while(finished < M) {
			// 가장 가까이 있는 승객 고르기
			boolean isFind = false;
			boolean[][] visited = new boolean[N][N];
			PriorityQueue<int[]> queue = new PriorityQueue<>((int[]o1, int[]o2)->{
				if(o1[2] == o2[2]) {
					if(o1[0] == o2[0]) {
						return o1[1] - o2[1];
					}
					else {
						return o1[0] - o2[0];
					}
				}
				else {
					return o1[2] - o2[2];
				}
			});
			queue.offer(new int[] {r, c, 0, fuel});
			visited[r][c] = true;
			while(!queue.isEmpty()) {
				int[] q = queue.poll();
				//System.out.println(q[0] + " " + q[1] + " - "+place[q[0]][q[1]]);
				
				if(place[q[0]][q[1]] > 1) {
					int cust = place[q[0]][q[1]] - 2;
					int distToDest = getDestDist(q, custInfo[cust], place);
					//System.out.println(distToDest);
					if(distToDest != -1) {
						fuel = q[3] + distToDest;
						place[q[0]][q[1]] = 0;
						finished++;
						isFind = true;
						r = custInfo[cust][2];
						c = custInfo[cust][3];
						break;
					}
					else {
						fuel = -1;
						break;
					}
				}
				else if(place[q[0]][q[1]] == 0){
					if(q[3]-1 > 0) {
						for(int[] d: dir) {
							int newR = d[0] + q[0];
							int newC = d[1] + q[1];
							
							if(0<=newR&&newR<N && 0<=newC && newC<N) {
								if(visited[newR][newC]) continue;
								queue.offer(new int[] {newR, newC, q[2]+1, q[3] - 1});
								visited[newR][newC] = true;
							}
						}
					}
				}
			}
			
			if(!isFind || fuel == -1) {
				fuel = -1;
				break;
			}
			
		}
		System.out.println(fuel);
	}
	
	public int getDestDist(int[] info, int[] cust, int[][] place) {
		int r = info[0];
		int c = info[1];
		int fuel = info[3];
		int dist = -1;
		int N = place.length;
		int[][] dir = {{-1,0}, {0,-1}, {0, 1}, {1, 0}};

		boolean[][] visited = new boolean[place.length][place.length];
		Deque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r, c, 0, fuel});
		visited[r][c] = true;
		while(!queue.isEmpty()) {
			int[] q= queue.poll();

			if(q[0] == cust[2] && q[1] == cust[3]) {
				dist = q[2];
				fuel = q[3];
				break;
			}
			else if(place[q[0]][q[1]] != 1) {
				if(q[3]-1 >= 0) {
					for(int[] d: dir) {
						int newR = d[0] + q[0];
						int newC = d[1] + q[1];
						
						if(0<=newR&&newR<N && 0<=newC && newC<N) {
							if(visited[newR][newC]) continue;
							queue.offer(new int[] {newR, newC, q[2]+1, q[3] - 1});
							visited[newR][newC] = true;
						}
					}
				}
			}
		}
		
		return dist;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		b19238 b = new b19238();
		b.solution();
	}

}

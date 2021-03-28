package CodingTest.baekjoon;

//MST - Prim PQ
//1: 26
//Prim 쓸 때 minEdge에 INF 남아있는지 꼭 확인하기!!

import java.io.*;
import java.util.*;
public class b17472 {

	static int N, M, islandNum;
	static int[][] board;
	static List<List<int[]>> islands;
	
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board=  new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 개수 계산
		islands = new ArrayList<>();
		islandNum = getIslandNum();
		
		// Prim
		int[] minEdge = new int[islandNum]; // 각 섬까지 가는 최단거리
		Arrays.fill(minEdge, INF);
		boolean[] visited = new boolean[islandNum];
		
		PriorityQueue <int[]> queue = new PriorityQueue<>((o1, o2)->{
			return Integer.compare(o1[1], o2[1]);
		});
		
		queue.offer(new int[] {0, 0}); // 섬 번호, 다리길이
		minEdge[0] = 0;
		int result = 0;
		int cnt = 0;
		while(!queue.isEmpty()) {
			int[] q= queue.poll();
			if(visited[q[0]]) continue;
			visited[q[0]] = true;
			
			
			result += q[1];
			cnt += 1;
			if(cnt == islandNum) break;
			//System.out.println(Arrays.toString(q) + " "+result);

			// 다른 섬과 거리 탐색
			for(int i=0;i<islandNum;i++) {
				if(visited[i]) continue;
				
				int d = getBridgeLength(q[0], i);
				
				if(d != -1 && d >=2 ) {
					if(minEdge[i] > d) {
						//System.out.println(q[0]+" "+i +" = "+d);
						queue.offer(new int[] {i, d});
						minEdge[i] = d;
					}
					
				}
			}
		}
		
		if(result == 0 || cnt != islandNum) result = -1;
		//System.out.println(Arrays.toString(minEdge));
		System.out.println(result);
	}
	
	static int getBridgeLength(int a, int b) {
		int minDist = INF;
		int [][] distance = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		
		for(int[] arr1: islands.get(a)) {
			for(int[] arr2 : islands.get(b)) {
				// 4방향으로 arr1지점부터 arr2로 갈 수 있는지 확인
				if(arr1[0] != arr2[0] && arr1[1] != arr2[1]) continue;
				
				int distCount = 0;
				boolean isFound = false;
				for(int i=arr1[0]+1;i<N;i++) {
					if(i==arr2[0] && arr1[1] == arr2[1]) {
						isFound = true;
						break;
					}
					
					if(board[i][arr1[1]] == 1) break; // 다른 섬에 부딪힐 경우
					
					distCount++;
				}
				
				if(isFound && distCount >= 2) {
					minDist = Math.min(distCount, minDist);
				}
				
				distCount = 0;
				isFound = false;
				for(int i=arr1[0]-1;i>=0;i--) {
					if(i==arr2[0] && arr1[1] == arr2[1]) {
						isFound = true;
						break;
					}
					
					if(board[i][arr1[1]] == 1) break; // 다른 섬에 부딪힐 경우
					
					distCount++;
				}
				
				if(isFound && distCount >= 2) {
					minDist = Math.min(distCount, minDist);
				}
				
				distCount = 0;
				isFound = false;
				for(int i=arr1[1]+1;i<M;i++) {
					if(i==arr2[1] && arr1[0] == arr2[0]) {
						isFound = true;
						break;
					}
					
					if(board[arr1[0]][i] == 1) break; // 다른 섬에 부딪힐 경우
					
					distCount++;
				}
				
				if(isFound && distCount >= 2) {
					minDist = Math.min(distCount, minDist);
				}
				
				distCount = 0;
				isFound = false;
				for(int i=arr1[1]-1;i>=0;i--) {
					if(i==arr2[1] && arr1[0] == arr2[0]) {
						isFound = true;
						break;
					}
					
					if(board[arr1[0]][i] == 1) break; // 다른 섬에 부딪힐 경우
					
					distCount++;
				}
				
				if(isFound && distCount >= 2) {
					minDist = Math.min(distCount, minDist);
				}
			}
		}
		
		if(minDist == INF) return -1;
		return minDist;
	}

	
	static int getIslandNum() {
		//bfs
		Deque <int[]> queue = new ArrayDeque<>();
		boolean [][] visit = new boolean[N][M];
		int count = 0;
		List<int[]> island = new ArrayList<>();
		loop: for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(board[i][j] == 1) {
					queue.offer(new int[] {i, j});
					island.add(new int[] {i, j});
					visit[i][j] = true;
					break loop;
				}
			}
		}
		
		int [][] distance = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		
		while(!queue.isEmpty()) {
			int[] q= queue.poll();	
			
			for(int d=0;d<4;d++) {
				int newR = q[0] + distance[d][0];
				int newC = q[1] + distance[d][1];
			
				if(0<=newR&&newR<N&&0<=newC&&newC<M) {
					if(!visit[newR][newC] && board[newR][newC] == 1) {
						queue.offer(new int[] {newR, newC});
						island.add(new int[] {newR, newC});
						visit[newR][newC] = true;
					}
				}
			}
			
			if(queue.isEmpty()) {
				count++;
				islands.add(island);
				island = new ArrayList<>();
				loop: for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						if(board[i][j] == 1 && !visit[i][j]) {
							queue.offer(new int[] {i, j});
							island.add(new int[] {i, j});
							visit[i][j] = true;
							break loop;
						}
					}
				}
			}
		}
		
		return count;
	}

}

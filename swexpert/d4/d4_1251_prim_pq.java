package CodingTest.swexpert.d4;

import java.io.*;
import java.util.*;
public class d4_1251_prim_pq {

	static int N;
	static int[][] islands;
	static double E;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			N = stoi(in.readLine());
			islands = new int[N][2];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++) {
				islands[i][0] = stoi(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++) {
				islands[i][1] = stoi(st.nextToken());
			}
			
			E = Double.parseDouble(in.readLine());
			
			
			System.out.println("#"+tc+" "+prim_pq());
		}
	}
	

	// 우선순위 큐를 활용한 Prim 알고리즘
	static long prim_pq() {
		PriorityQueue <double[]> queue = new PriorityQueue<>((o1, o2)->{
			return Double.compare(o1[1], o2[1]);
		});
		
		// 각 섬으로 가는 비용 중 가장 작은 값 저장
		double [] minEdge  = new double[N];
		Arrays.fill(minEdge, Long.MAX_VALUE);
		
		// 섬 방문 체크
		boolean [] visited = new boolean[N];
		
		// 우선순위 큐에 0번 섬 넣기 {섬 번호, Spanning Tree 비용}
		queue.offer(new double[] {0, 0});
		minEdge[0] = 0;
		
		double result = 0;
		int count = 0;
		while(!queue.isEmpty()) {
			double[] q = queue.poll();
			
			// 방문했다고 마킹된 섬이면 이미 최소 비용이 구해졌기 때문에 Pass
			if(visited[(int)q[0]]) continue;
			
			// 방문 체크 & 총 비용에 추가
			result += q[1];
			visited[(int)q[0]] = true;
			
			// 백트래킹
			if(++count == N-1) break;

			// 방문하지 않은 모든 섬 순회
			for(int i=0;i<N;i++) {
				if(visited[i] || i == (int)q[0]) continue;
				
				// 섬까지 거리 구하기
				double dist = getDist(islands[(int)q[0]], islands[i]);
				if(getEnvFee(dist) < minEdge[i]) {
					// 최소 비용 갱신할 수 있으면 큐에 추가
					minEdge[i] = getEnvFee(dist);
					queue.offer(new double[] {i, minEdge[i]});
				}
			}
			
		}
		
		return Math.round(result);
	}
	
	// 섬과 섬 사이의 거리 구하는 메서드
	static double getDist(int[] o1, int[] o2) {
		return Math.sqrt(Math.pow((o1[0]-o2[0]), 2) + Math.pow((o1[1]-o2[1]), 2));
	}
	
	// 환경 부담금 구하는 메서드
	static double getEnvFee(double len) {
		return E * Math.pow(len, 2);
	}
	
	// 문자열 정수로 만드는 메서드
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}

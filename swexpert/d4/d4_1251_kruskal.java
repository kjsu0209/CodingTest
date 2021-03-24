package CodingTest.swexpert.d4;
import java.io.*;
import java.util.*;
public class d4_1251_kruskal {

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
			
			
			System.out.println("#"+tc+" "+kruskal());
		}
	}
	

	
	static class Edge implements Comparable<Edge>{
		int from, to;
		double weight;

		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.weight, o.weight);
		}
		
		
	}
	
	static int[] parents; // 섬이 속한 집합
	//static int[] cNum; // 집합 트리의 하위 자식 노드 개수
	
	// Kruskal's 알고리즘
	static long kruskal() {
		parents = new int[N];
		//cNum = new int[N];
		
		double minEdge[] = new double[N];
		Arrays.fill(minEdge, Double.MAX_VALUE);
		
		// 간선리스트 만들기
		ArrayList <Edge> edges = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i==j) continue;
				edges.add(new Edge(i, j, getEnvFee(getDist(islands[i], islands[j]))));
			}
		}
		
		// 비용이 작은 간선 순으로 정렬
		Collections.sort(edges);
		
		make();
		
		double result = 0;
		int count = 0; // 방문 정점 개수
		for(Edge edge: edges) {
			if(union(edge.from, edge.to)) {
				// 사이클 발생하지 않는 경우
				result += edge.weight;
				
				// count 증가시키고 정점 다 방문했을 경우 멈추기
				if(++count == N-1) break;
			}
		}
		
		return Math.round(result);
	}
	
	// 초기화
	static void make() {
		for(int i=0;i<parents.length;i++) {
			parents[i] = i;
			//cNum[i] = 1;
		}
	}
	
	// a가 어느 집합에 속해 있는지 리턴
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		// cycle 발생
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		// 자식 수 더 많은 쪽에 붙이기
//		if(cNum[aRoot] > cNum[bRoot]) {
//			parents[bRoot] = aRoot;
//			cNum[aRoot] += cNum[bRoot];
//		}
//		else {
//			parents[aRoot] = bRoot;
//			cNum[bRoot] += cNum[aRoot];
//		}
//		
		return true;
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

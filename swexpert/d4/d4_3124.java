package CodingTest.swexpert.d4;
import java.io.*;
import java.util.*;

public class d4_3124 {

	static int V, E;
	static List<int[]> edges[]; // 인접 리스트
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edges = new ArrayList[V+1];
			for(int i=0;i<V+1;i++) edges[i] = new ArrayList<>();
			
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(in.readLine());
				int A =  Integer.parseInt(st.nextToken());
				int B =  Integer.parseInt(st.nextToken());
				int C =  Integer.parseInt(st.nextToken());
				
				edges[A].add(new int[] {B, C});
				edges[B].add(new int[] {A, C});
			}
			
			System.out.println("#"+tc+" "+prim());
		}
	}
	
	static long kruskal() {
		int result = 0;
		
		int[] parents = new int[V+1];
		for(int i=1;i<V+1;i++) parents[i] = i;
		int[] cNum = new int[V+1];
		
		
		
		return result;
	}
	
	static long prim() {
		PriorityQueue <int[]> queue = new PriorityQueue<>((o1, o2)->{
			return Integer.compare(o1[1], o2[1]);
		});
		
		int [] minEdge = new int[V+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		boolean [] visited = new boolean[V+1];
		
		queue.offer(new int[] {1, 0});
		
		minEdge[0] = 0;
		minEdge[1] = 0;
		
		long result = 0;
		while(!queue.isEmpty()) {
			int[] q = queue.poll(); // 가장 가중치가 작은 간선 뽑기
			
			if(visited[q[0]]) continue; // 이미 가장 작은 간선을 찾은 노드면 패스.
			result += q[1];
			visited[q[0]] = true;
			
			// 노드와 연결된 다른 노드 중 간선 길이를 갱신할 수 있는 노드 정보 큐에 추가하기.
			// 우선순위 큐라서 자동으로 가중치가 작은 간선이 앞에 오도록 할 수 있다.
			for(int[] e: edges[q[0]]) {
				if(!visited[e[0]] && e[1] < minEdge[e[0]]) {
					minEdge[e[0]] = e[1];
					queue.offer(e);
				}
			}
		}
				
		return result;
	}

}

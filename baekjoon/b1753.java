// 다익스트라
package CodingTest.baekjoon;
import java.io.*;
import java.util.*;
public class b1753 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int V = stoi(st.nextToken());
		int E = stoi(st.nextToken());
		int INF = Integer.MAX_VALUE;
		
		int K = stoi(in.readLine());
		
		ArrayList<int[]> edges[] = new ArrayList[V+1];
		for(int i=0;i<edges.length;i++) edges[i] = new ArrayList<int[]>();
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(in.readLine());
			int u = stoi(st.nextToken());
			int v = stoi(st.nextToken());
			int w = stoi(st.nextToken());
			
			edges[u].add(new int[] {v, w});
		}
		
		int[] dist = new int[V+1];
		Arrays.fill(dist, INF);
		dist[K] = 0;
		
		PriorityQueue <int[]> queue = new PriorityQueue<>((o1, o2)->{
			return o1[1]-o2[1];
		});
		
		queue.offer(new int[] {K, 0});
		
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			
			for(int[] e: edges[q[0]]) {
				if(dist[e[0]] > q[1] + e[1]) {
					dist[e[0]] = q[1]+e[1];
					queue.offer(new int[] {e[0], dist[e[0]]});
				}
			}
		}
		
		for(int i=1;i<dist.length;i++) {
			if(dist[i] == INF) System.out.println("INF");
			else			System.out.println(dist[i]);
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}

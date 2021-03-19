// 0:20
package CodingTest.swexpert.d4;
import java.io.*;
import java.util.*;
public class d4_1238 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// directed graph
		int T = 10;
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			
			HashMap <Integer, Set<Integer>> graph = new HashMap<>();
			
			st= new StringTokenizer(in.readLine());
			
			for(int i=0;i<N/2;i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				if(graph.containsKey(from)) {
					graph.get(from).add(to);
				}else {
					Set<Integer> set = new HashSet<>();
					set.add(to);
					graph.put(from, set);
				}
			}
			
			// bfs
			int lastPNum = 0;
			int lastPTime = 0;
			
			boolean[] visited = new boolean[101];
			
			Queue <int []> queue  = new LinkedList<>();
			queue.offer(new int[] {S, 0});
			visited[S] = true;
			while(!queue.isEmpty()) {
				int[] q = queue.poll();
				//System.out.println(Arrays.toString(q));
				if(lastPTime < q[1]) {
					lastPTime = q[1];
					lastPNum = q[0];
				}
				else if(lastPTime == q[1]) {
					if(lastPNum < q[0]) {
						lastPTime = q[1];
						lastPNum = q[0];
					}
				}
				
				if(!graph.containsKey(q[0])) continue;
				
				for(int e: graph.get(q[0])) {
					if(!visited[e]) {
						queue.offer(new int[] {e, q[1]+1});
						visited[e] = true;
					}
				}
			}
			
			System.out.println("#"+tc+" "+lastPNum);
		}
	}

}

package CodingTest.swexpert.d4;
import java.io.*;
import java.util.*;

public class d4_3124_kruskal {

	static int V, E;
	static List<int[]> edges[]; // 인접 리스트
	
	static int[] parents;
	static int[] cNum;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			PriorityQueue <int[]> queue = new PriorityQueue<>((o1, o2)->{
				return Integer.compare(o1[2], o2[2]);
			});
			
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(in.readLine());
				int A =  Integer.parseInt(st.nextToken());
				int B =  Integer.parseInt(st.nextToken());
				int C =  Integer.parseInt(st.nextToken());
				
				queue.add(new int[] {A, B, C});
			}
			
			parents = new int[V+1];
			cNum = new int[V+1];

			for(int i=0;i<V+1;i++) {
				parents[i] = i;
				cNum[i] = 1;
			}
			
			long result = 0;
			while(!queue.isEmpty()) {
				int[] q = queue.poll();
				
				// A, B가 같은 부모를 가지고 있는지 확인
				if(find(q[0]) == find(q[1])) {
					// 사이클 발생
					continue;
				}
				
				union(q[0], q[1]);
				result+=q[2];
				
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		if(cNum[aRoot] > cNum[bRoot]) {
			parents[bRoot] = aRoot;
			cNum[aRoot] += cNum[bRoot];
		}
		else {
			parents[aRoot] = bRoot;
			cNum[bRoot] += cNum[aRoot];
		}
		
		return true;
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}

	
}

package CodingTest.baekjoon;
import java.io.*;
import java.util.*;
public class b1260 {

	static class Node{
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
		
		
	}
	
	
	static Node[] graph;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		graph = new Node[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			for(Node h=graph[from];h!=null;h=h.next) {
				if(h.vertex == to) {
					break;
				}
				if(h.next == null) {
					if(h.vertex < to)
						h.next = new Node(to, h.next);
					else
						graph[from] = new Node(to, h);
					break;
				}
				
				if(h.next.vertex > to && to > h.vertex) {
					h.next = new Node(to, h.next);
					break;
				}
			}
			
			if(graph[from] == null) {
				graph[from] = new Node(to, null);
			}
			
			for(Node h=graph[to];h!=null;h=h.next) {
				if(h.vertex == from) {
					break;
				}
				if(h.next == null) {
					if(h.vertex < from)
						h.next = new Node(from, h.next);
					else
						graph[to] = new Node(from, h);
					break;
				}
				
				if(h.next.vertex >= from && from > h.vertex) {
					h.next = new Node(from, h.next);
					break;
				}
			}
			
			if(graph[to] == null) {
				graph[to] = new Node(from, null);
			}
			
		}
		
		visited= new boolean[N+1];
		dfs(V);
		System.out.println();
		visited= new boolean[N+1];
		bfs(V);
		System.out.println();
	}
	
	static void dfs(int v) {
		visited[v] = true;
		System.out.print(v+" ");
		for(Node t=graph[v]; t != null; t = t.next) {
			if(!visited[t.vertex]) {
				dfs(t.vertex);
			}
		}
	}
	
	static void bfs(int start) {
		Deque<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int q = queue.poll();
			
			System.out.print(q+" ");
			
			for(Node t=graph[q];t!=null;t = t.next) {
				if(!visited[t.vertex]) {
					queue.offer(t.vertex); 
					visited[t.vertex] = true;
				}
					
			}
		}
		
	}

}

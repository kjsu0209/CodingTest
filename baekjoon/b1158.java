package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b1158 {
	public static class Node {
		Node link;
		Node pre;
		int num;
		
		public Node(int num) {
			this.num = num;
		}
	}
	
	

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Node head = new Node(1);
		LinkedList<Integer> list = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Node cur = head;
		for(int i=2;i<=N;i++) {
			cur.link = new Node(i);
			cur.link.pre = cur;
			cur = cur.link;
		}
		
		int count = 0;
		int index = 0;
		System.out.print("<");
		
		cur = head;
		while(cur != null) {
			count++;
			if(count == K) {
				count = 0;
				// 출력
				System.out.print(cur.num);
				// 노드 삭제
				if(cur.pre != null)
					cur.pre.link = cur.link;
				else
					head = cur.link;
				if(cur.link != null)
					cur.link.pre = cur.pre;
				
				// 마지막 노드가 아닐경우 쉼표 출력
				if(cur.link != null || cur.pre != null) {
					System.out.print(", ");
				}
			}
			// 다음 노드로 이동
			if(cur.link == null) {
				// 마지막 노드일 경우 헤드로 이동
				cur = head;
			}
			else {
				cur = cur.link;
			}
		}
		
		System.out.println(">");
	}

}

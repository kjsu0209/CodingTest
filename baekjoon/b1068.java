package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b1068 {
	public static void deleteNode(int[] tree, int index) {
		if(index >= tree.length) return;
		
		tree[index] = 0;
		deleteNode(tree, index*2);
		deleteNode(tree, index*2+1);
	}
	
	public static int findLeafNode(int[] tree, int index) {
		int count = 0;
		if(index*2+1 < tree.length) {
			if(tree[index*2] == 0 && tree[index*2+1] == 0) {
				return 1;
			}
			if(tree[index*2] != 0)
				count += findLeafNode(tree, index*2);
			if(tree[index*2+1] != 0)
				count += findLeafNode(tree, index*2+1);
		}else {
			return 1;
		}
		
		return count;
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int[] tree= new int[N*2];
		for(int i=1;i<=N;i++) {
			int n = Integer.parseInt(st.nextToken())+1;
			if(n == 0) continue;
			// 왼쪽 노드 있으면 오른쪽 삽입
			if(tree[2*n] != 0) {
				tree[2*n+1] = i;
			}else {
				tree[2*n] = i;
			}
		}
		
		int D = Integer.parseInt(in.readLine())+1;
		
		// 지우기
		deleteNode(tree, D);
		
		// 리프 노드 찾기
		int result = findLeafNode(tree, 1);
		System.out.println(result);
	}

}

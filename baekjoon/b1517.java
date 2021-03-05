package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b1517 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{return -(o1[0]-o2[0]);});

		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {arr[i], i});
		}
		
		int count = 0;
		int index = N-1;
		
		while(!pq.isEmpty()) {
			int[] q = pq.poll();
			// 배치할 값 중 가장 큰값과 큰값이 가야할 인덱스까지 거리 구하기
			count += index - q[1];
		}
		
		System.out.println(count);
	}

}

// bfs
package CodingTest.baekjoon;
import java.io.*;
import java.util.*;
public class b9205_bfs {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(in.readLine());
		for(int tc=1;tc<=t;tc++) {
			int n = Integer.parseInt(in.readLine());
			int[][] arr = new int[n+2][2];
			for(int i=0;i<n+2;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Deque <int[]> queue = new ArrayDeque<>();
			boolean[] memo = new boolean[n+2]; // 방문 여부
			memo[0] = true;
			
			queue.offer(new int[] {0, 0});
			int result = -1;
			while(!queue.isEmpty()) {
				int[] q = queue.poll();
				
				if(q[0] == n+1) {
					result = q[1];
					break;
				}
				
				for(int i=0;i<n+2;i++) {
					if(getDist(arr[i], arr[q[0]]) <= 1000 && !memo[i]) {
						queue.offer(new int[] {i, getDist(arr[i], arr[q[0]])});
						memo[i] = true;
					}
				}
			}
			
			if(result == -1) {
				System.out.println("sad");
			}
			else {
				System.out.println("happy");
			}
		}
	}
	
	
	static int getDist(int[] a, int[] b) {
		int result = 0;
		if(a[0] < 0 && b[0] >= 0) {
			result = Math.abs(a[0]) + b[0];
		}
		else if(b[0] < 0 && a[0] >= 0) {
			result = Math.abs(b[0]) + a[0];
		}
		else {
			result = Math.abs(Math.abs(a[0]) - Math.abs(b[0]));
		}
		
		if(a[1] < 0 && b[1] >= 0) {
			result += Math.abs(a[1]) + b[1];
		}
		else if(b[1] < 0 && a[1] >= 0) {
			result += Math.abs(b[1]) + a[1];
		}
		else {
			result += Math.abs(Math.abs(a[1]) - Math.abs(b[1]));
		}
		//System.out.println(a[0]+", "+a[1] + "<=>"+b[0]+", "+b[1] +"=" + result);
		return result;
	}

}

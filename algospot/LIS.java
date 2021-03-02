package CodingTest.algospot;
import java.util.*;
import java.io.*;
public class LIS {

	static int N;
	static int[] arr;
	static int[] cache;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(in.readLine());
		
		for(int tc = 0;tc<C;tc++) {
			N = Integer.parseInt(in.readLine());
			arr = new int[N];
			cache = new int[N];
			Arrays.fill(cache, -1);
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
			
			int maxLen = 0;
			
			
			System.out.println(lis(0));
		}
	}
	
	
	// start부터 증가하는 부분 수열 중 최대 길이 반환
	static int lis(int start) {
		if(cache[start] != -1) return cache[start];
		cache[start] = 1;
		for(int i=start+1;i<N;i++) {
			if(arr[start] < arr[i]) {
				cache[start] = Math.max(lis(i)+1, cache[start]);
			}
		}
		return cache[start];
	}

}

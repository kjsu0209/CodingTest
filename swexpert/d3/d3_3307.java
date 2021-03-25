package CodingTest.swexpert.d3;
import java.io.*;
import java.util.*;
public class d3_3307 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(in.readLine());
			int[] arr = new int[N];
			int[] LIS = new int[N];
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
			
			int max = 0;
			for(int i=0;i<N;i++) {
				LIS[i] = 1;
				for(int j=0;j<i;j++) {
					if(arr[j] <= arr[i] && LIS[i] < LIS[j]+1) {
						LIS[i] = LIS[j]+1;
					}
				}
				
				max = Math.max(max, LIS[i]);
			}
			
			System.out.println("#"+tc+" "+max);
		}
		
	}

}

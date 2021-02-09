package CodingTest.swexpert.d3;
import java.util.*;
import java.io.*;
public class d3_8338 {
	static int maxNum;
	static int[] numbers;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			numbers = new int[N];
			for(int i=0;i<N;i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			maxNum = 0;
			calculator(N, 0, 0);
			
			System.out.println("#"+tc+" "+maxNum);
		}
	}
	
	static void calculator(int N, int idx, int num) {
		if(idx == N) {
			maxNum = Math.max(maxNum, num);
			return;
		}
		
		calculator(N, idx+1, num + numbers[idx]);
		calculator(N, idx+1, num * numbers[idx]);
	}

}

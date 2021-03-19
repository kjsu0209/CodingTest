package CodingTest.swexpert;
import java.io.*;
import java.util.*;
public class t_4008 {

	static int[] operNum;
	static int[] numbers;
	static int maxNum;
	static int minNum;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(in.readLine());
			operNum = new int[4];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i=0;i<4;i++) {
				operNum[i] = Integer.parseInt(st.nextToken());
			}
			
			numbers = new int[N];
			st = new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			maxNum = Integer.MIN_VALUE;
			minNum= Integer.MAX_VALUE;
			
			permutation(1, numbers[0], 0, 0, 0, 0);
			
			System.out.println("#"+tc+" " + Math.abs(maxNum-minNum));
		}
	}
	
	static void permutation(int cnt, int num, int p, int m, int t, int d){
		if(cnt == numbers.length) {
			//기저조건
			minNum = Math.min(minNum, num);
			maxNum = Math.max(maxNum, num);
			return;
		}
		
		if(p < operNum[0]) {
			permutation(cnt+1, num + numbers[cnt], p+1, m, t, d);
		}
		if(m < operNum[1]) {
			permutation(cnt+1, num - numbers[cnt], p, m+1, t, d);
		}
		if(t < operNum[2]) {
			permutation(cnt+1, num * numbers[cnt], p, m, t+1, d);
		}
		if(d < operNum[3]) {
			permutation(cnt+1, num / numbers[cnt], p, m, t, d+1);
		}
	}

}

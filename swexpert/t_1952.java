package CodingTest.swexpert;
import java.io.*;
import java.util.*;
public class t_1952 {
	
	static int daily, monthly, threeMonthly, yearly;
	static int[] plan;
	static int minFee;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			daily = Integer.parseInt(st.nextToken());
			monthly = Integer.parseInt(st.nextToken());
			threeMonthly = Integer.parseInt(st.nextToken());
			yearly = Integer.parseInt(st.nextToken());
			
			plan = new int[13];
			st = new StringTokenizer(in.readLine());
			for(int i=1;i<13;i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			minFee = yearly;
			
			compareFeeYearly(1, 0);
			
			System.out.println("#"+tc+" "+minFee);
		}
	}
	
	// 재귀
	static void compareFeeYearly(int month, int fee) {
		if(month > 12) {
			minFee = Math.min(minFee, fee);
			return;
		}
		// 1개월 선택
		compareFeeYearly(month+1, fee+compareFee(month));
		
		// 3개월 선택
		if(month+2 <= 12)
			compareFeeYearly(month+3, fee+compareFeeThreeMonthly(0, month, 0));
	}
	
	static int compareFeeThreeMonthly(int cnt, int month, int fee) {
		if(cnt == 3) {
			if(fee < threeMonthly)
				return fee;
			else
				return threeMonthly;
		}
		return compareFeeThreeMonthly(cnt+1, month+1, fee+compareFee(month));
	}
	
	static int compareFee(int month) {
		//1일 이용권* 이용횟수 & 1달 이용권 비교 후 리턴
		if(monthly < plan[month]*daily)
			return monthly;
		else
			return plan[month]*daily;
	}

}

package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b5904 {

	static int N;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		mooMoo(0, 0);
	}
	
	// k, 지금까지의 문자열 길이
	static void mooMoo(int k, int lenNum) {
		// 앞으로 문자열 길이
		int l = lenNum+1+(k+2)+lenNum;
		
		// N 범위에 들어가면 문자열 제작
		if(N <= l) {
			StringBuilder sb = new StringBuilder();
			sb.append("m");
			for(int i=0;i<k+2;i++) sb.append("o");
			
			System.out.println(sb.toString().charAt(l-N));
		}
		else {
			mooMoo(k+1, l);
		}
	}

}

package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b2839 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int max5Bag = -1; // 최대한 5키로를 넣어 본 나머지
		// remain이 3의 배수가 될 때까지 5키로봉지에 담기
		for(int i=0;i<=N/5;i++) {
			int remain = N;
			// i : 5키로 봉지 개수
			remain -= 5*i;
			
			if(remain%3 == 0) {
				// 3의 배수면 maxRemain에 저장
				max5Bag = i;
			}
		}
		
		int min3Bag = (N-max5Bag*5)/3;
		if(max5Bag == -1) min3Bag = 0;
		System.out.println((max5Bag+min3Bag));
	}

}

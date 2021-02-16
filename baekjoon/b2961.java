// 0:12
// 바이너리 카운팅으로 부분집합 생성
package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b2961 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[][] ingredient = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			ingredient[i][0] = Integer.parseInt(st.nextToken());
			ingredient[i][1] = Integer.parseInt(st.nextToken());
		}
		int minDiff = Integer.MAX_VALUE;
		
		// 집합의 경우의 수를 bit로 표현. 
		// ex) i=0 => 0000 (0), i=1 => 0001({3}), i=3 => 0011({2, 3})
		for(int i=0;i<(1<<N);i++) {
			int bitter = 0;
			int sour = 1;
			
			// i는 부분집합의 단위, j는 배열 원소 단위
			// 배열 순회하면서 집합 경우의 수에 마킹된 인덱스인지 확인.
			for(int j=0;j<N;j++) {
				// 마킹되었으면 작업 수행
				if((i & (1<<j)) != 0) { // &연산으로 해당 인덱스가 마킹되었는지 확인
					sour *= ingredient[j][0];
					bitter += ingredient[j][1];
				}
			}

			if(bitter ==0 && sour==1) continue;
			minDiff = Math.min(minDiff, Math.abs(bitter-sour));
		}
		System.out.println(minDiff);
	}

}

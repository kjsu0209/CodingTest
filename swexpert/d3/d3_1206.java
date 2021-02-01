// 0:12
// StringTokenizer

import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/input_d3_1206.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(in.readLine());
			String input = in.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int []apt = new int[N];
			int index = 0;
			while(st.hasMoreTokens()) {
				apt[index++] = Integer.parseInt(st.nextToken());
			}
			
			int viewPoint = 0; //조망권 있는 세대 수
			for(int i=0;i<N;i++) {
				// 왼쪽에서 제일 높은거 구하기
				// 왼쪽 조망 중 물 포함할 경우
				int A = 0;
				for(int j=i-2;j<i;j++) {
					if(j<0) continue;
					A = Math.max(A, apt[j]);
				}
				
				// 오른쪽에서 제일 높은거 구하기
				// 오른쪽 조망 중 물 포함할 경우
				int B = 0;
				for(int j=i+1;j<=i+2;j++) {
					if(j>=N) continue;
					B = Math.max(B, apt[j]);
				}
				// 해당 빌딩 높이 - 양쪽중 최대놓이 = 조망권 있는 세대 수
				viewPoint += apt[i] - Math.max(A, B) > 0 ? apt[i] - Math.max(A, B): 0;
			}
			System.out.println("#"+tc+" "+viewPoint);
		}
	}

}

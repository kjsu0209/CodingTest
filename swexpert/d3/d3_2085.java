package CodingTest.swexpert.d3;

import java.util.*;
import java.io.*;
public class d3_2085 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(in.readLine());
			int[][] farm = new int[N][N];
			
			for(int i=0;i<N;i++) {
				String line = in.readLine();
				for(int j=0;j<N;j++) {
					farm[i][j] = Integer.parseInt(line.charAt(j)+"");
				}
			}
			
			int totalCount =0;
			for(int i=0;i<N/2;i++) {
				// 중앙으로부터 양쪽으로 펼쳐지는 거리 : i
				int countLine = farm[i][N/2];
				for(int j=1;j<=i;j++) {
					countLine += farm[i][(N/2) + j];
					countLine += farm[i][(N/2) - j];
				}
				//System.out.println(countLine);
				totalCount += countLine;
			}
			
			for(int i=N/2;i>=0;i--) {
				// 중앙으로부터 양쪽으로 펼쳐지는 거리 : i
				int countLine = farm[N-i-1][N/2];
				for(int j=1;j<=i;j++) {
					countLine += farm[N-i-1][(N/2) + j];
					countLine += farm[N-i-1][(N/2) - j];
				}
				//System.out.println(countLine);
				totalCount += countLine;
			}
			
			System.out.println("#"+tc+" "+totalCount);
		}
	}

}

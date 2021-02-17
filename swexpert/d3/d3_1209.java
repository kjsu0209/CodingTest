package CodingTest.swexpert.d3;
import java.util.*;
import java.io.*;
public class d3_1209 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		for(int t=1;t<=T;t++) {
			int tc = Integer.parseInt(in.readLine());
			int [][] arr = new int[100][100];
			
			for(int i=0;i<100;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j=0;j<100;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int maxSum = Integer.MIN_VALUE;
			int sum = 0;
			
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					sum+= arr[i][j];
				}
				maxSum = Math.max(sum, maxSum);
				
				sum = 0;

			}
			
						
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					sum+= arr[j][i];
				}
				maxSum = Math.max(sum, maxSum);
				
				sum = 0;
			}
			
		
			
			for(int i=0;i<100;i++) {
				sum+= arr[i][i];
				
			}
			
			maxSum = Math.max(sum, maxSum);
	
			sum = 0;
			
			for(int i=0;i<100;i++) {
				sum+= arr[99-i][i];
				
			}
			
			maxSum = Math.max(sum, maxSum);
			
			
			System.out.println("#"+tc+" "+maxSum);
		}
	}

}

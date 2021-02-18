package CodingTest.swexpert.d5;
import java.io.*;
import java.util.*;
public class d5_1247 {
	static int N;
	static int[] company;
	static int[] home;
	static int[][] customer;
	static int minMove;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(in.readLine());
			company = new int[2];
			home = new int[2];
			customer = new int[N][2];
			StringTokenizer st = new StringTokenizer(in.readLine());
			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			for(int i=0;i<N;i++) {
				customer[i][0] = Integer.parseInt(st.nextToken());
				customer[i][1] = Integer.parseInt(st.nextToken());
			}

			minMove = Integer.MAX_VALUE;
			
			dfs(company[0], company[1], 0, 0, 0);
			System.out.println("#"+tc+" "+minMove);
		}
	}
	
	
	static void dfs(int row, int col, int flag, int custCount, int move) {
		if(custCount == N) {
			minMove = Math.min(minMove, move+calDist(row, col, home[0], home[1]));
			return;
		}
		
		for(int i=0;i<N;i++) {
			if((flag&1<<i)!=0) continue;
			int d = calDist(row, col, customer[i][0], customer[i][1]);
			if(move+d < minMove) {
				dfs(customer[i][0], customer[i][1], flag |1<<i, custCount+1, move+d);
			}
			
		}
	}
	
	static int calDist(int r1, int c1, int r2, int c2) {
		return Math.abs(r1-r2) + Math.abs(c1-c2);
	}

}

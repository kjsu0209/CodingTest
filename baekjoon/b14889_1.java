// 조합문제
package CodingTest.baekjoon;
import java.io.*;
import java.util.*;
public class b14889_1 {

	static int N;
	static int[][] board;
	static int[] numbers;
	static int minDiff;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		board = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		numbers = new int[N];
		minDiff = Integer.MAX_VALUE;
		combination(0, 0);
		
		System.out.println(minDiff);
	}
	
	static void combination(int cnt, int index) {
		if(cnt == N/2) {
			minDiff = Math.min(minDiff, calculDiff());
			
			return;
		}
		
		for(int i=index;i<N;i++) {
			numbers[i] = 1;
			combination(cnt+1, i+1);
			numbers[i] = 0;
		}
	}
	
	static int calculDiff() {
		int startS = 0;
		int linkS = 0;
		
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(numbers[i] == numbers[j]) {
					if(numbers[i] == 0) {
						startS += board[i][j];
					}else {
						linkS += board[i][j];
					}
				}
			}
		}
		
		return Math.abs(startS-linkS);
	}
}

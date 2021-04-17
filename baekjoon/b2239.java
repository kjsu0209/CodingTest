// dfs + 백트래킹
// 0:34
package CodingTest.baekjoon;
import java.io.*;
import java.util.*;
public class b2239 {

	static final int N = 9;
	static boolean isFinished;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] board = new int[N][N];
		
		for(int i=0;i<N;i++) {
			char[] cArr = in.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				board[i][j] = (int)cArr[j] - 48;
			}
		}
		isFinished = false;
		dfs(0, 0, board);
	}
	
	public static void dfs(int r, int c, int[][] b) {
		if(isFinished) return;
		// 새로운 배열에 복사
		int[][] board = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				board[i][j] = b[i][j];
			}
		}
					
		//현재 위치에 값이 비어 있으면 값을 넣는다.
		if(board[r][c] == 0) {
			List<Integer> numbers = getAvailableNumbers(r, c, board);
			for(int n: numbers) {
				board[r][c] = n;
				
				// 마지막 칸일 경우
				if(r == N-1 && c == N-1) {
					//종료
					printBoard(board);
				}
				else {
					//옆 칸으로 이동
					if(c== N-1) {
						dfs(r+1, 0, board);
					}
					else {
						dfs(r, c+1, board);
					}
				}
				
			}
		}
		else {
			// 현재 위치에 값이 있으면 옆 칸으로 이동한다.
			// 현재 위치에 값이 있고, 마지막 칸이면 종료한다.
			if(r == N-1 && c == N-1) {
				//종료
				printBoard(board);
				return;
			}
			else {
				//옆 칸으로 이동
				if(c== N-1) {
					dfs(r+1, 0, board);
				}
				else {
					dfs(r, c+1, board);
				}
			}
		}
		
	}
	
	public static void printBoard(int[][]board) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(board[i][j]+"");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
		isFinished = true;
	}
	
	public static List<Integer> getAvailableNumbers(int r, int c, int [][]b) {
		List<Integer> numbers = new ArrayList<>();
		for(int i=1;i<=9;i++) {
			if(isAvailable(r, c, i, b)) {
				numbers.add(i);
			}
		}
		
		return numbers;
	}
	
	public static boolean isAvailable(int r, int c, int num, int[][]b) {
		// 정사각형 블럭에 넣을 수 있는지 확인
		boolean[] check = new boolean[N+1];
		int startR = ((r+3)/3 - 1)*3;
		int startC = ((c+3)/3 - 1)*3;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				check[b[startR+i][startC+j]] = true;
			}
		}
		if(check[num]) {
			return false;
		}
		
		// 가로줄 확인
		check = new boolean[N+1];
		for(int i=0;i<N;i++) {
			check[b[r][i]] = true;
		}
		if(check[num]) {
			return false;
		}
		
		// 세로줄 확인
		check = new boolean[N+1];
		for(int i=0;i<N;i++) {
			check[b[i][c]] = true;
		}
		if(check[num]) {
			return false;
		}
		
		return true;
	}

}

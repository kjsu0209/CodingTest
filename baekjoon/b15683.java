package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b15683 {

	static ArrayList<int[]> cctvPos;
	static int[] numbers;
	static int minArea;
	static int[][] board;
	static int N, M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		board = new int[N][M];
		
		cctvPos = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = stoi(st.nextToken());
				if(board[i][j]>=1 && board[i][j]<=5) cctvPos.add(new int[] {i, j});
			}
		}
		
		// 각 cctv의 방향 지정
		numbers = new int[cctvPos.size()];
		minArea = Integer.MAX_VALUE;
		
		permutation(0);
		
		System.out.println(minArea);
	}
	
	static void permutation(int cnt) {
		if(cnt == cctvPos.size()) {
			minArea = Math.min(minArea, calArea());
			return;
		}
		
		// 방향 지정하고
		for(int i=0;i<4;i++) {
						
			// 재귀호출
			numbers[cnt] = i;
			permutation(cnt+1);
		}
	}
	
	static void markLeft(boolean[][] b, int cRow, int cCol) {
		// 왼쪽
		for(int i=cCol+1;i<M;i++) {
			if(board[cRow][i] == 6) break;
			b[cRow][i] = true;
		}
	}
	

	static void markRight(boolean[][] b, int cRow, int cCol) {
		// 오른쪽
		for(int i=cCol-1;i>=0;i--) {
			if(board[cRow][i] == 6) break;

			b[cRow][i] = true;
		}
	}
	
	static void markUp(boolean[][] b, int cRow, int cCol) {
		// 위쪽
		for(int i=cRow-1;i>=0;i--) {
			if(board[i][cCol] == 6) break;

			b[i][cCol] = true;
		}
	}
	
	
	static void markDown(boolean[][] b, int cRow, int cCol) {
		// 아래쪽
		for(int i=cRow+1;i<N;i++) {
			if(board[i][cCol] == 6) break;

			b[i][cCol] = true;
		}
	}
	
	static int calArea() {
		boolean [][] b = new boolean[N][M];
		for(int cI=0;cI<cctvPos.size();cI++) {
			int cRow = cctvPos.get(cI)[0];
			int cCol = cctvPos.get(cI)[1];
			int c = board[cRow][cCol];
			
			// 방향
			int dir = numbers[cI];
			
			if(c == 1) {
				if(dir == 0) {
					markUp(b, cRow, cCol);
				}
				if(dir == 1) {
					markRight(b, cRow, cCol);
				}
				if(dir == 2) {
					markDown(b, cRow, cCol);
				}
				if(dir == 3) {
					markLeft(b, cRow, cCol);
				}
			}
			else if(c == 2) {
				if(dir%2 == 0) {
					markUp(b, cRow, cCol);
					markDown(b, cRow, cCol);
				}
				else {
					markRight(b, cRow, cCol);
					markLeft(b, cRow, cCol);
				}
			}
			else if(c == 3) {
				if(dir == 0) {
					markUp(b, cRow, cCol);
					markRight(b, cRow, cCol);

				}
				if(dir == 1) {
					markRight(b, cRow, cCol);
					markDown(b, cRow, cCol);

				}
				if(dir == 2) {
					markDown(b, cRow, cCol);
					markLeft(b, cRow, cCol);

				}
				if(dir == 3) {
					markLeft(b, cRow, cCol);
					markUp(b, cRow, cCol);

				}
			}
			else if(c == 4) {
				if(dir == 0) {
					markLeft(b, cRow, cCol);
					markUp(b, cRow, cCol);
					markRight(b, cRow, cCol);

				}
				if(dir == 1) {
					markUp(b, cRow, cCol);
					markRight(b, cRow, cCol);
					markDown(b, cRow, cCol);

				}
				if(dir == 2) {
					markRight(b, cRow, cCol);
					markDown(b, cRow, cCol);
					markLeft(b, cRow, cCol);

				}
				if(dir == 3) {
					markDown(b, cRow, cCol);
					markLeft(b, cRow, cCol);
					markUp(b, cRow, cCol);

				}
			}
			else {
				markLeft(b, cRow, cCol);
				markUp(b, cRow, cCol);
				markRight(b, cRow, cCol);
				markDown(b, cRow, cCol);
			}
		}
		int count = 0;

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!b[i][j] && board[i][j] == 0) {
					count++;
				}
			}
		}
		
		return count;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}

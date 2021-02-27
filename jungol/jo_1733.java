package CodingTest.jungol;
import java.io.*;
import java.util.*;
public class jo_1733 {

	static int [][] board;
	static int N = 19;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		board = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] black = findWinner(1);
		int[] white = findWinner(2);
		
		if(black == null && white == null) {
			//무승부
			System.out.println(0);
		}
		else if(black == null) {
			System.out.println(2);
			System.out.println(white[0]+" "+white[1]);
		}
		else if(white == null){
			System.out.println(1);
			System.out.println(black[0]+" "+black[1]);
		}
	}
	static int limitR = 19;
	static int limitC = 19;
	static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1 ,1}, {1, -1}, {-1, 1}};
	static int[] findWinner(int find) {
		
		
		// 현 단계에서의 최솟값
		int row = 19;
		int col = 19;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(board[i][j] != find) continue;
				// 상하 오목 확인
				// 좌우 오목 확인
				// 오른쪽 대각선 오목 확인
				// 왼쪽 대각선 오목 확인
				
				for(int d=0;d<8;d+=2) {
					limitR = 19;
					limitC = 19;
					int sum = 0;
					
					sum += dfs(i, j, d, find);
					sum += dfs(i, j, d+1, find);
					sum--;
					if(sum == 5) {
						// 오목 완성
						//System.out.println("find "+find+" - "+limitR+" "+limitC);
						if(limitC<col) {
							col = limitC;
							row = limitR;
						}
						else if(col == limitC) {
							row = Math.min(limitR, i);
						}
					}
				}
			}
		}
		
		if(row == 19 && col==19) return null;
		
		return new int[] {row+1, col+1};
	}
	
	static int dfs(int row, int col, int dir, int find) {
		if(board[row][col] != find) return 0;
		if(col < limitC) {
			limitC = col;
			limitR = row;
		}
		else if(col == limitC) {
			limitR = Math.min(row, limitR);
		}
		
		int result=1;
		int newR = row + direction[dir][0];
		int newC = col + direction[dir][1];
		
		if(0<=newR && newR<N && 0<=newC && newC<N) {
			result += dfs(newR, newC, dir, find);
		}
		return result;
	}

}

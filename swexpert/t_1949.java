// 0:30
// dfs문제.
// bfs로 풀다가 visit체크 때문에 dfs로 바꿈
package CodingTest.swexpert;
import java.io.*;
import java.util.*;
public class t_1949 {

	static int N, K;
	static int[][] board;
	static 	boolean[][] visit;
	static int longest;
	static	int[][] dir = {{-1, 0},{0, 1},{1,0},{0, -1}};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			board = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0;j<N;j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			longest = 0; // 가장 긴 등산로의 길이
			
			List <int[]> highest = new ArrayList<>();
			int high = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(high < board[i][j]) {
						highest.clear();
						high = board[i][j];
						highest.add(new int[] {i, j});
					}
					else if(high == board[i][j]) {
						highest.add(new int[] {i, j});
					}
				}
			}
			for(int[] a: highest) {
				visit = new boolean[N][N];
				visit[a[0]][a[1]] = true;
				dfs(a[0], a[1], 1, false, board[a[0]][a[1]]);
			}
			
			System.out.println("#"+tc+" "+longest);
			
			
		}
		
		
	}
	static void dfs(int row, int col, int len, boolean useK, int h) {
		longest = Math.max(longest, len);
		
		for(int d=0;d<4;d++) {
			int newR = row + dir[d][0];
			int newC = col + dir[d][1];
			
			if(0<=newR &&newR<N && newC>=0 && newC<N) {
				if(visit[newR][newC]) continue;
				// 다음 칸이 현재 값보다 작을 경우 바로 내려가기
				if(board[newR][newC] < h) {
					visit[newR][newC] = true;
					dfs(newR, newC, len+1, useK, board[newR][newC]);
					visit[newR][newC] = false;
				}
				else {
					// K 쓸 수 있으면 쓰기
					if(!useK) {
						for(int k=1;k<=K;k++) {
							if(board[newR][newC] - k < h) {
								visit[newR][newC] = true;
								dfs(newR, newC, len+1, true, board[newR][newC]-k); // k만큼 깎기
								visit[newR][newC] = false;
							}
						}
					}
				}
			}
		}
	}
}

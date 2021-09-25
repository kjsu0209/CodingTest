// 0:40
// Simulation
// 왼쪽, 위쪽 끝 칸 기준으로 90도씩 회전
// (A, B) -> (-B, -A) -> (-A, -B) -> (B, -A)
package bj;

import java.io.*;
import java.util.*;

public class b14500 {

	public void solution() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer initS = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(initS.nextToken());
		int M = Integer.parseInt(initS.nextToken());
		
		int[][] board = new int[N][M];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][][] tetromino = {
				{{0, 0}, {0, 1}, {0, 2}, {0, 3}}, // 한줄짜리
				{{0, 0}, {0, 1}, {1, 0}, {1, 1}}, // 정사각형
				{{0, 0}, {1, 0}, {2, 0}, {2, 1}}, // 니은
				{{0, 0}, {1, 0}, {2, 0}, {2, -1}}, // 니은 대칭
				{{0, 0}, {1, 0}, {1, 1}, {2, 1}}, // 지그재그
				{{0, 0}, {1, 0}, {1, -1}, {2, -1}}, // 지그재그 대칭
				{{0, 0}, {0, 1}, {0, 2}, {1, 1}} // 볼록이
		};
		
		int answer = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				for(int[][] tetro: tetromino) {
					for(int turn=0;turn<4;turn++) {
						
						// 계산
						int result = countScore(i, j, board, tetro, turn);
						answer = Math.max(result, answer);
					}
				}
			}
		}
		System.out.println(answer);
	}
	
	public int countScore(int r, int c, int[][] board, int[][] tetroOrigin, int turn) {
		int score = 0;
		int[][] tetro = new int[4][2];
		
		if(turn == 0) {
			for(int i=0;i<4;i++) {
				int A = tetroOrigin[i][0];
				int B = tetroOrigin[i][1];
				
				tetro[i][0] = A;
				tetro[i][1] = B;
			}
		}
		else if(turn == 1) {
			for(int i=0;i<4;i++) {
				int A = tetroOrigin[i][0];
				int B = tetroOrigin[i][1];
				
				tetro[i][0] = B * -1;
				tetro[i][1] = A;
			}
		}
		else if(turn == 2) {
			for(int i=0;i<4;i++) {
				int A = tetroOrigin[i][0];
				int B = tetroOrigin[i][1];
				
				tetro[i][0] = A * -1;
				tetro[i][1] = B * -1;
			}
		}
		else if(turn == 3) {
			for(int i=0;i<4;i++) {
				int A = tetroOrigin[i][0];
				int B = tetroOrigin[i][1];
				
				tetro[i][0] = B;
				tetro[i][1] = A * -1;
			}
		}
		
		for(int [] tet : tetro) {
			int newR = r + tet[0];
			int newC = c + tet[1];
			
			if(0<=newR && newR <board.length && 0<=newC&&newC<board[0].length) {
				score += board[newR][newC];
			}
			else {
				// 잘못 놓았을 경우
				return -1;
			}
		}
		
		return score;
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		b14500 b = new b14500();
		b.solution();
	}

}

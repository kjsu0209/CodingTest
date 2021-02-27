package CodingTest.baekjoon;
import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b10158 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int w = stoi(st.nextToken());
		int h = stoi(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		int p = stoi(st.nextToken()); // col
		int q = h-stoi(st.nextToken())-1; // row
		
		int t = stoi(in.readLine());
		
		int row = q;
		int col = p;
		// 오른쪽 위, 오른쪽 아래, 왼쪽 아래, 왼쪽 위
		int[][]dir = {{-1, 1}, {1, 1}, {1, -1}, {-1, -1}}; 
		int head = 0; // 초기 방향
		
		int time = 0;
		while(true) {
			// 한번 움직일 때 벽에 부딪힐때까지 가기
			// 오른쪽 위
			if(head == 0) {
				// 먼저 충돌하는 면 찾기
				if(w-col > row) {
					// 윗면 먼저 충돌할 경우
					int move = row; // 충돌할때까지 움직여야 하는 시간
					if(time+move >= t) {
						move = time+move-t;
					}
					
					// 오른쪽 위 충돌
					row = 0;
					col += dir[head][1]*move;
					// 오른쪽 아래 반사
					head = 1;
				
					if(time+move == t) {
						System.out.println(col + " "+row);
						break;
					}
					time+= move;
				}
				else {
					//옆면 먼저 충돌할 경우
					int move = w - col; // 충돌할때까지 움직여야 하는 시간
					if(time+move >= t) {
						move = time+move-t;
					}
					
					// 오른쪽 위 충돌
					col = w;
					row += dir[head][0]*move;
					// 왼쪽 위 반사
					head = 3;
				
					if(time+move == t) {
						System.out.println(col + " "+row);
						break;
					}
					time+= move;
				}
			}
			// 오른쪽 아래
			else if(head == 1) {
				// 먼저 충돌하는 면 찾기
				if(w-col > h-row) {
					// 아랫면 먼저 충돌할 경우
					int move = h- row; // 충돌할때까지 움직여야 하는 시간
					if(time+move >= t) {
						move = time+move-t;
					}
					
					// 오른쪽 아래 충돌
					row = h;
					col += dir[head][1]*move;
					// 오른쪽 위 반사
					head = 0;
				
					if(time+move == t) {
						System.out.println(col + " "+row);
						break;
					}
					time+= move;
				}
				else {
					//옆면 먼저 충돌할 경우
					int move = w - col; // 충돌할때까지 움직여야 하는 시간
					if(time+move >= t) {
						move = time+move-t;
					}
					
					// 오른쪽 아래 충돌
					col = w;
					row += dir[head][0]*move;
					// 왼쪽 아래 반사
					head = 2;
				
					if(time+move == t) {
						System.out.println(col + " "+row);
						break;
					}
					time+= move;
				}
			}
			// 왼쪽 아래
			else if(head == 2) {
				// 먼저 충돌하는 면 찾기
				if(col > h-row) {
					// 아랫면 먼저 충돌할 경우
					int move = h- row; // 충돌할때까지 움직여야 하는 시간
					if(time+move >= t) {
						move = time+move-t;
					}
					
					// 왼쪽 아래 충돌
					row = h;
					col += dir[head][1]*move;
					// 왼쪽 위 반사
					head = 3;
				
					if(time+move == t) {
						System.out.println(col + " "+row);
						break;
					}
					time+= move;
				}
				else {
					//옆면 먼저 충돌할 경우
					int move = col; // 충돌할때까지 움직여야 하는 시간
					if(time+move >= t) {
						move = time+move-t;
					}
					
					// 왼쪽 아래 충돌
					col = 0;
					row += dir[head][0]*move;
					// 오른쪽 아래 반사
					head = 1;
					
					if(time+move == t) {
						System.out.println(col + " "+row);
						break;
					}
					time+= move;
				}
			}
			// 왼쪽 위
			else if(head == 3) {
				// 먼저 충돌하는 면 찾기
				if(col > row) {
					// 윗면 먼저 충돌할 경우
					int move = row; // 충돌할때까지 움직여야 하는 시간
					if(time+move >= t) {
						move = time+move-t;
					}
					
					// 왼쪽 위 충돌
					row = 0;
					col += dir[head][1]*move;
					// 왼쪽 아래 반사
					head = 2;
				
					if(time+move == t) {
						System.out.println(col + " "+row);
						break;
					}
					time+= move;
				}
				else {
					//옆면 먼저 충돌할 경우
					int move = col; // 충돌할때까지 움직여야 하는 시간
					if(time+move >= t) {
						move = time+move-t;
					}
					
					// 왼쪽 위 충돌
					col = 0;
					row += dir[head][0]*move;
					// 오른쪽 위 반사
					head = 0;
				
					if(time+move == t) {
						System.out.println(col + " "+row);
						break;
					}
					time+= move;
				}
			}
			
		}
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}

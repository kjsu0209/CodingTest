import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/input_d4_1210.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=0;tc<10;tc++) {
			int T = Integer.parseInt(in.readLine());
			int [][] ladder = new int[100][100];
			
			for(int i=0;i<100;i++) {
				String input = in.readLine();
				StringTokenizer st = new StringTokenizer(input, " ");
				for(int j=0;j<100;j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int [] pos = new int[2]; // 현재 위치
			int moveDir = 0; // -1: 왼쪽 1: 오른쪽 0: 중립
			
			//도착점 찾기
			for(int i=0;i<100;i++) {
				if(ladder[99][i] == 2) {
					pos[0] = 99;
					pos[1] = i;
					break;
				}
			}
			while(pos[0] > 0) {
				// 꼭대기 갈때까지 반복
				//System.out.println(Arrays.toString(pos));
				// 위로 올라가기
				if(ladder[pos[0]-1][pos[1]] != 0) {
					if(moveDir == 0) {
						// 좌우에 이동 가능한지 확인
						if(pos[1] > 0) {
							if(ladder[pos[0]][pos[1]-1] == 1) {
								pos[1] --;
								moveDir = -1;
								continue;
							}
						}
						if(pos[1]+1 < 100) {
							if(ladder[pos[0]][pos[1]+1] == 1) {
								pos[1] ++;
								moveDir = 1;
								continue;
							}
						}
					}
					
					// 안되면 위로 올라가기
					pos[0] --;
					moveDir = 0;
				}
				else {
					// 가던길 가기
					if(moveDir == -1) {
						pos[1] --;
					}else {
						pos[1] ++;
					}
				}
			}
			
			System.out.println("#"+T+" " + pos[1]);
		}
	}

}

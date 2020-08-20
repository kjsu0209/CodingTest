package baekjoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class b15685 {

	public int b15685(int n, int info[][]) {
		int answer = 0;
		int [][] map = new int[200][200];
		for(int i=0;i<200;i++) {
			for(int j=0;j<200;j++) {
				map[i][j] = 0;
			}
		}
		int nowX = 0, nowY = 0;
		int endX = 0, endY = 0;

		int mapX = 0, mapY = 0;
		int dir=0;
		
		for(int i=0;i<n;i++) {
			ArrayList listX = new ArrayList();
			ArrayList listY = new ArrayList();

			nowX = info[i][0]*2;
			nowY = info[i][1]*2;

			dir = info[i][2];
			for(int j=0;j<info[i][3]+1;j++) {
				//끝점 표시
				endX = nowX;
				endY = nowY;
				switch(dir) {
					case 0: 
						map[nowY][nowX+1] = 1;
						endX = nowX+2;
						break;
					case 1:
						map[nowY-1][nowX] = 1;
						endY = nowY-2;
						break;
					case 2:
						map[nowY][nowX-1] = 1;
						endX = nowX-2;
						break;
					case 3:
						map[nowY+1][nowX] = 1;
						endY = nowY+2;
						break;
				}
				//선분 표시
				if(j == 0) {
					int check = 0;
					for(int k=0;k<listX.size();k++) {
						if(((int)listX.get(k)==nowX)&&((int)listY.get(k)==nowY)) {
							check = 1;
						}
					}
					if(check ==0) {
						map[nowY][nowX] += 1;
						listX.add(nowX);
						listY.add(nowY);
					}
				}
				int check2 = 0;
				for(int k=0;k<listX.size();k++) {
					if(((int)listX.get(k)==endX)&&((int)listY.get(k)==endY)) {
						check2 = 1;
					}
				}
				if(check2 ==0) {
					map[endY][endX] += 1;
					listX.add(endX);
					listY.add(endY);
				}
				//위치 이동
				nowX = endX;
				nowY = endY;
				
				dir = curve(dir);
			}
		}
		
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				System.out.print(map[i][j]);
				if(map[i][j] != 0 && map[i+1][j]!= 0 && map[i+2][j] != 0 && map[i][j+1]!= 0&& map[i+2][j+1]!= 0&& map[i][j+2]!= 0&& map[i+1][j+2]!= 0&& map[i+2][j+2]!= 0) {
					answer += map[i][j];
					answer += map[i][j+2];
					answer += map[i+2][j];
					answer += map[i+2][j+2];
				}
			}
			System.out.println();
		}
		
		
		return answer;
	}
	
	public int curve(int dir) {
		return (dir+7)%4;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		b15685 b = new b15685();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int [][] info = new int[n][4];
		for(int i=0;i<n;i++) {
			for(int j=0;j<4;j++) {
				info[i][j] = s.nextInt();
			}
		}
		
		System.out.println("" + b.b15685(n, info));
		
	}

}

package baekjoon;

import java.util.Scanner;

public class b14503 {
	public int b14503(int n, int m, int r, int c, int d, int[][]map) {
		int count = 0;
		int head = d;
		int headR = 0;
		int headC = 0;
		int flag = 0;
		while(true) {

			flag = 0;
			if(map[r][c] == 0) {
				map[r][c] = 2;
				count ++;
			}
			for(int i=0;i<4;i++) {
				head = turn(head);
				if(head == 0) {
					headR = r - 1;
					headC = c;
				}
				else if(head == 1) {
					headR = r;
					headC = c + 1;
				}
				else if(head == 2) {
					headR = r + 1;
					headC = c;
				}
				else if(head == 3) {
					headR = r;
					headC = c - 1;
				}
				
				if(headR<n && headC<m && headR >=0 && headC >= 0) {
					if(map[headR][headC] == 0) {
						r = headR;
						c = headC;
						break;
					}
				}
				
				if(i==3) {
					flag = 1;
					break;
				}
			}
			
			if(flag == 1) {
				//후진 가능 확인
				if(head == 0) {
					headR = r + 1;
					headC = c;
				}
				else if(head == 1) {
					headR = r;
					headC = c - 1;
				}
				else if(head == 2) {
					headR = r - 1;
					headC = c;
				}
				else if(head == 3) {
					headR = r;
					headC = c + 1;
				}
				
				if(headR<n && headC<m && headR >=0 && headC >= 0) {
					if(map[headR][headC] == 1) {
						break;
					}
					else{
						r = headR;
						c = headC;
					}
				}else {
					break;
				}
			}
			
			

		}
		
		return count;
	}
	public int turn(int d) {
		return Math.abs((d+3)%4);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, m, r, c, d;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		r = s.nextInt();
		c = s.nextInt();
		d = s.nextInt();
		int [][] map = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = s.nextInt();
			}
		}
		b14503 b = new b14503();
		System.out.println(b.b14503(n, m, r, c, d, map));
	}

}

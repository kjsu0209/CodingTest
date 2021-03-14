package CodingTest.swexpert;
import java.io.*;
import java.util.*;
public class t_4014 {

	static int N, X;
	static int[][] board;
	static int[][] slide;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			board = new int[N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0;j<N;j++) {
					board[i][j] = Integer.parseInt(st.nextToken().trim());
				}
			}
			
			// 행, 열 활주로 설치 가능한지 검사
			int count = 0;
			for(int i=0;i<N;i++) {
				slide = new int[N][N];
				if(checkRunway(0, i, 1, slide) == 1) {
					count++;
					//System.out.println(i+"열 활주로 건설 가능");
				}
				slide = new int[N][N];
				if(checkRunway(i, 0, 0, slide) == 1) {
					count++;
					//System.out.println(i+"행 활주로 건설 가능");
				}			
			}
			
			System.out.println("#"+tc+" "+count);
		}
	}
	
	static int checkRunway(int row, int col, int direction, int[][] slide) {
		// 종료조건
		if(direction == 0) { // 가로 - col이 바뀜
			if(col == N-1)
				return 1;
		}
		else if(direction == 1) {//세로 - row가 바뀜
			if(row == N-1)
				return 1;
		}
		
		// 다음 칸 높이가 1 다를 경우
		if(direction == 0) {
			if(Math.abs(board[row][col] - board[row][col+1]) == 1) {
				// 낮은 칸에 경사로 둘 수 있는지 확인
				if(board[row][col] < board[row][col+1]) {
					boolean flag = true;
					if(col-X+1 <0) return 0;
					for(int c = col; c>= col-X+1 ;c--){
						if(slide[row][c] != 0|| board[row][c] != board[row][col]) {
							flag = false;// 이미 다른 경사로가 있을 경우
							break;
						}
					}
					
					if(!flag) {
						return 0;
					}
					
					for(int c = col; c>= col-X+1 ;c--){
						slide[row][c] = 1; //경사로 마킹
					}
					return checkRunway(row, col+1, direction, slide);
				}else {
					boolean flag = true;
					if(col+X >= N) return 0;

					for(int c = col+1; c<= col+X ;c++){
						if(slide[row][c] != 0 || board[row][c] != board[row][col+1]) {
							flag = false;// 이미 다른 경사로가 있을 경우
							break;
						}
					}
					
					if(!flag) {
						return 0;
					}
					
					for(int c = col+1; c<= col+X ;c++){
						slide[row][c] = 1; //경사로 마킹
					}
					return checkRunway(row, col+1, direction, slide);
				}
			}
			else if(Math.abs(board[row][col] - board[row][col+1]) == 0) {
				// 높이 같을 경우
				return checkRunway(row, col+1, direction, slide);
			}
			else {
				// 높이 2 이상 나서 경사로 잇어도 소용없는 경우
				return 0;
			}
		}
		else {
			if(Math.abs(board[row][col] - board[row+1][col]) == 1) {
				// 낮은 칸에 경사로 둘 수 있는지 확인
				if(board[row][col] < board[row+1][col]) {
					boolean flag = true;
					if(row-X+1 <0) return 0;

					for(int c = row; c>= row-X+1;c--){
						if(slide[c][col] != 0  || board[c][col] != board[row][col]) {
							flag = false;// 이미 다른 경사로가 있을 경우
							break;
						}
					}
					
					if(!flag) {
						return 0;
					}
					
					for(int c = row; c>= row-X+1;c--){
						slide[c][col] = 1; //경사로 마킹
					}
					return checkRunway(row+1, col, direction, slide);
				}else {
					boolean flag = true;
					if(row+X >= N) return 0;

					for(int c = row+1; c<= row+X;c++){
						if(slide[c][col] != 0 || board[c][col] != board[row+1][col]) {
							flag = false;// 이미 다른 경사로가 있을 경우
							break;
						}
					}
					
					if(!flag) {
						return 0;
					}
					
					for(int c = row+1; c<= row+X;c++){
						slide[c][col] = 1; //경사로 마킹
					}
					return checkRunway(row+1, col, direction, slide);
				}
			}
			else if(Math.abs(board[row][col] - board[row+1][col]) == 0) {
				// 높이 같을 경우
				return checkRunway(row+1, col, direction, slide);
			}
			else {
				// 높이 2 이상 나서 경사로 잇어도 소용없는 경우
				return 0;
			}
		}
	}

}

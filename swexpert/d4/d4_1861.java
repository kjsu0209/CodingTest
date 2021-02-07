package CodingTest.swexpert.d4;
import java.util.*;
import java.io.*;
public class d4_1861 {
	static int[][] room;
	static int N;
	static int maxNum= Integer.MIN_VALUE;
	static int[] maxIndex;
	static int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};// 상 하 좌우
	
	static void moveRoom(int startRow, int startCol, int row, int col, int count) {
		boolean hasMoved = false;
		for(int i=0;i<4;i++) {
			int newR = row + direction[i][0];
			int newC = col + direction[i][1];
			
			if(0<=newR&&newR<N&&0<=newC&&newC<N) {
				if(room[newR][newC] == room[row][col]+1) {
					moveRoom(startRow, startCol, newR, newC, count+1); // 다음 방으로 이동
					hasMoved = true;
				}
			}
		}
		
		if(!hasMoved) {
			if(count > maxNum) { // 최댓값 갱신
				maxNum = count;
				maxIndex[0] = startRow;
				maxIndex[1] = startCol;
			}else if(count == maxNum) {
				if(room[maxIndex[0]][maxIndex[1]] > room[startRow][startCol]) { // 최댓값과 같을경우 방 번호가 작은 방을 저장
					maxIndex[0] = startRow;
					maxIndex[1] = startCol;
				}
			}
		}
		return;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			maxNum = Integer.MIN_VALUE;
			maxIndex = new int[2];
			N = Integer.parseInt(in.readLine());
			room = new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j=0;j<N;j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					moveRoom(i, j, i, j, 0);
				}
			}
			
			System.out.println("#"+tc+" "+room[maxIndex[0]][maxIndex[1]]+" "+(maxNum+1));
		}
	}

}

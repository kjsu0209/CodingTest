// 미로찾기 문제 
package CodingTest.swexpert.d4;
import java.util.*;
import java.io.*;
public class d4_1226 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=0;tc<10;tc++) {
			int T = Integer.parseInt(in.readLine());
			char[][] maze = new char[16][16];
			for(int i=0;i<16;i++) {
				maze[i] = in.readLine().toCharArray();
			}
			
			if(canEscape(maze)) {
				System.out.println("#"+T+" 1");
			}
			else {	
				System.out.println("#"+T+" 0");
			}
		}
	}
	
	
	static boolean canEscape(char[][] maze) {
		boolean result = false;
		int [][]dir = {{-1, 0},{0,1},{1,0},{0, -1}};
		
		// 왼쪽 벽 짚고 가기
		int[] pos = {1, 1};
		int head = 1; // 상 우 하 좌
		
		// 방향 정하기
		if(maze[1][2] == '1') {
			head = 2;
		}
		else if(maze[0][1] == '1') {
			head = 1;
		}
		else {
			return false;
		}
		
		boolean initMove = true;

		while(true) {
			if(maze[pos[0]][pos[1]] == '3') {
				return true;
			}
			
			// 자기 자리로 돌아왔을 때 종료 (길 못찾았다는 뜻)
			if(!initMove && pos[0] == 1 && pos[1] == 1) {
				break;
			}
			
			// 방향 기준으로 왼쪽 벽따라 이동
			
			// 전진한 상태에서 왼쪽 벽이 있고, 전진할 수 있는 경우
			char leftVal = getLeftValue(maze, head, pos[0]+dir[head][0], pos[1]+dir[head][1]);
			char forVal = getForValue(maze, head, pos[0], pos[1]);
			//System.out.println("("+head+")"+pos[0]+" " +pos[1] + " >  " +leftVal+" "+forVal);
			if(leftVal == '1' && forVal !='1') {
				pos[0] += dir[head][0];
				pos[1] += dir[head][1];
				initMove = false;
			}
			// 전진할 수 없는 경우 (시계방향 회전)
			else if(forVal =='1') {
				head = (head+5)%4;
				initMove = false;
			}
			// 앞에 아무것도 없는 경우(왼쪽 벽타고 가기)
			else if(leftVal != '1' && forVal !='1') {
				// 전진 후 왼쪽으로 이동
				pos[0] += dir[head][0];
				pos[1] += dir[head][1];
				
				head = (head+3)%4;
				pos[0] += dir[head][0];
				pos[1] += dir[head][1];
				initMove = false;
			}
		}
		
		return result;
	}
	
	static char getForValue(char[][]maze, int head, int r, int c) {
		int [][]dir = {{-1, 0},{0,1},{1,0},{0, -1}};

		int newR = r + dir[head][0];
		int newC = c + dir[head][1];
		
		return maze[newR][newC];
	}
	
	static char getLeftValue(char[][]maze, int head, int r, int c) {
		int [][]dir = {{-1, 0},{0,1},{1,0},{0, -1}};

		int newR = r + dir[(head+3)%4][0];
		int newC = c + dir[(head+3)%4][1];
		
		return maze[newR][newC];
	}

}

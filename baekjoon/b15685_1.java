// 1:10
// 구현 문제
// 처음에 직접 배열에 그림 그렸는데
// 사각형 꼭짓점만 확인하면 돼서 문제가 훨씬 간단해짐.
package CodingTest.baekjoon;
import java.io.*;
import java.util.*;
public class b15685_1 {

	static List<int[]>[] dragon;
	static int[][] direction = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};// x증가 y감소 x감소 y증가

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		dragon = new ArrayList[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			dragon[i] = new ArrayList<>();
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int startD = Integer.parseInt(st.nextToken());
			int generation = Integer.parseInt(st.nextToken());
			
			int endX = startX + direction[startD][0];
			int endY = startY + direction[startD][1];
			dragon[i].add(new int[] {startX, startY, endX, endY, startD});
			makeDragon(i, 0, 0, generation);
		}
		
		// 배열에 커브 찍기
		int [][] board = new int[101][101];
		for(List<int[]> a: dragon) {
			for(int[] e: a) {
				board[e[1]][e[0]] = 1;
				board[e[3]][e[2]] = 1;
			}
		}
		
		//for(int[] b: board) System.out.println(Arrays.toString(b));
		// 정사각형 개수 확인
		int count = 0;
		for(int i=0;i<board.length-1;i++) {
			for(int j=0;j<board.length-1;j++) {
				if(isSquare(board, i, j)) {
					//System.out.println(i+" "+j);
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
	
	static boolean isSquare(int[][] board, int row, int col) {
		if(board[row][col] != 1) return false;
		if(board[row][col+1] != 1) return false;
		if(board[row+1][col] != 1) return false;
		if(board[row+1][col+1] != 1) return false;
		return true;
	}
	
	static void makeDragon(int dNum, int index, int generation, int G) {
		if(generation == G) {
			// 세대 수에 도달시 만들기 종료
			return;
		}
		
		//현재 세대에서 드래곤 커브 붙이고 다음 세대로 넘어감
		for(int i=dragon[dNum].size()-1;i>=0;i--) {
			dragon[dNum].add(getNewCurve(dragon[dNum].get(dragon[dNum].size()-1), dragon[dNum].get(i)[4]));
		}
		
		makeDragon(dNum, index, generation+1, G);
	}
	
	
	static int[] getNewCurve(int[] arr, int dir) {
		
		int newDir = (dir+1)%4;//90도 회전
		
		//마지막으로 추가된 커브의 끝에 붙임
		int startX = arr[2];
		int startY = arr[3];
		
		int endX = startX + direction[newDir][0];
		int endY = startY + direction[newDir][1];
		
		int[] newItem = {startX, startY, endX, endY, newDir};
		return newItem;
	}

}

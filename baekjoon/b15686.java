package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b15686 {
	static int N;
	static int M;
	
	static int[] removed;
		
	static int[][] board;
	static ArrayList <int[]> chicken;
	static ArrayList <int[]> house;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		chicken = new ArrayList<>();
		house = new ArrayList<>();
		board = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 2) {
					chicken.add(new int[]{i, j});
				}
				else if(board[i][j] == 1) {
					house.add(new int[] {i, j});
				}
			}
		}
		
		// 치킨집 고르는 경우의 수 NCM 재귀로 구하기
		int result = Integer.MAX_VALUE;
		for(int m = 1; m <=M;m++) {
			removed = new int[m];
			result = Math.min(result, combination(0, 0, m));
		}
		
		System.out.println(result);
	}
	
	
	static int combination(int index, int cnt, int m) {
		if(cnt == m) {
			// 치킨 거리 찾기 작업 수행
			//System.out.println(Arrays.toString(removed));
			return findChickenDist();
		}
		
		int result = Integer.MAX_VALUE;
		for(int i=index; i<chicken.size();i++) {
			removed[cnt] = i;
			result = Math.min(result, combination(i+1, cnt+1, m));
		}
		
		return result;
	}
	
	static int findChickenDist() {
		int dist = 0;

		// 집별로 반복 돌려서 치킨 거리 찾기
		for(int i=0;i<house.size();i++) {
			dist += shortestDist(house.get(i));
		}
		
		return dist;
	}
	
	static int shortestDist(int[] pos) {
		int shortest = Integer.MAX_VALUE;
		
		for(int i=0;i<chicken.size();i++) {
			for(int j=0;j<removed.length;j++) {
				if(i == removed[j]) {
					int d = Math.abs(pos[0]-chicken.get(i)[0]) + Math.abs(pos[1]-chicken.get(i)[1]);
					shortest = Math.min(shortest, d);
					break;
				}
			}
			
		}
		
		return shortest;
	}

}

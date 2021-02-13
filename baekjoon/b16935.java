package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b16935 {
	static int [][] arr;
	static int[][] turnOper;
	static boolean[] isSelected;
	static int[] order;
	
	static int minVal;
	static int N, M, K;
	static int [][] origin;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		origin = new int[N][M];
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				origin[i][j] = arr[i][j];
			}
		}
		
		// 회전 연산
		turnOper = new int[K][3];
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			turnOper[i][0] = r;
			turnOper[i][1] = c;
			turnOper[i][2] = s;
		}
		
		// 순열 dfs
		isSelected = new boolean[K];
		order = new int[K];
		minVal = Integer.MAX_VALUE;

		dfs(0, K);
		System.out.println(minVal);
	}
	
	private static void dfs(int cnt, int K) {
		if(cnt == K) {
			// 연산 종료
			// 돌리기
			for(int z=0;z<K;z++) {
				turnArr(turnOper[order[z]][0], turnOper[order[z]][1], turnOper[order[z]][2]);
			}
			
			// 순서대로 돌리고 최솟값 검사
			for(int i=0;i<N;i++) {
				int sum = 0;
				for(int j=0;j<M;j++) {
					sum+= arr[i][j];
				}
				minVal = Math.min(minVal, sum);
			}
			
			// 배열 초기화
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					arr[i][j] = origin[i][j];
				}
			}
			return;
		}
		// 선택
		for(int i=0;i<K;i++) {
			if(!isSelected[i]){
				order[cnt] = i;
				isSelected[i] = true;
				dfs(cnt+1, K);
				isSelected[i] = false;
			}
		}
	}

	static void turnArr(int r, int c, int s) {
		
		int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; //하우상좌
		int depth = 2*s + 1;// 정사각형 변 길이 
		int [] pos = {r-s-1, c-s-1}; // 초기 위치
		for(int i=0;i<s;i++) {// 깊이
			int temp = arr[pos[0]][pos[1]];
			for(int t=0;t<4;t++) {
				for(int j=0;j<depth;j++) { // 이동
					int newR = pos[0] + dir[t][0];
					int newC = pos[1] + dir[t][1];
					
					// 유효할 경우에만 이동
					if(r-s-1+i<=newR && newR<r+s-i && c-s-1+i<=newC&& newC<c+s-i) {
						// 이동
						arr[pos[0]][pos[1]] = arr[newR][newC];
						// 위치 갱신
						pos[0] = newR;
						pos[1] = newC;
					}
				}
				//System.out.println(t + " / depth:"+ depth);
				for(int a=0;a<arr.length;a++) {
					//System.out.println(Arrays.toString(arr[a]));
				}
			}
			arr[pos[0]][pos[1]+1] = temp;
			// 안쪽으로 한칸 이동
			pos[0] += 1;
			pos[1] += 1;
			depth -= 2;
		}
	}
	

	

}

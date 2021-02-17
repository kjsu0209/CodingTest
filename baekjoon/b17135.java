package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b17135 {
	
	static int N, M, D;
	static int[][] board;
	static ArrayList<int[]> enemy;
	static int[] selected;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		board = new int[N+1][M];
		enemy = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) {
					enemy.add(new int[] {i, j});
				}
			}
		}
		
		// 궁수 배치 순열 구하기
		selected = new int[M];
		System.out.println(combination(0, 0, 0));
	}
	
	static int combination(int index, int cnt, int flag) {
		if(cnt == 3) {
			// 계산 수행
			return playGame(flag);
		}
		
		int result = Integer.MIN_VALUE;
		
		for(int i=index;i<M;i++) {
			if((flag & 1<<i) != 0) continue;
			selected[cnt] = i;
			result = Math.max(result, combination(i+1, cnt+1, flag | 1<<i));
		}
		
		return result;
	}
	
	static int playGame(int flag) {
		int [][] archer = new int[3][2];
		int cnt = 0;
		for(int i=0;i<M;i++) {
			if((flag & 1<<i) != 0) {
				archer[cnt][0] = N;
				archer[cnt][1] = i;
				cnt++;
			}
		}
		//System.out.println(Integer.toBinaryString(flag));

		// 적 관리 배열
		ArrayList <int[]> newEnemy = new ArrayList<>();
		for(int[] e : enemy) {
			newEnemy.add(new int[] {e[0], e[1]});
		}
		
		// 가장 왼쪽 적부터 죽이기 때문에 왼쪽부터 sort
		Collections.sort(newEnemy, (o1, o2)->{
			return o1[1] - o2[1];
		});
		
		int killCount = 0; // 제거한 적의 수 카운트
		
		while(!newEnemy.isEmpty()) {
			// 죽은 적 인덱스 큐
			boolean [] die = new boolean[newEnemy.size()];
			// 궁수가 공격하기
			for(int i=0;i<3;i++) {
				int minI = -1;
				int index = 0;
				int minDist = Integer.MAX_VALUE;
				
				// 최단 거리의 적 고르기
				for(int[] e: newEnemy) {
					if(minDist > getDist(e, archer[i]) && getDist(e, archer[i]) <= D) {
						minDist = getDist(e, archer[i]);
						minI = index;
					}
					index++;
				}
				
				// 적 골랐으면 죽인 리스트에 표시
				if(minI != -1) {
					die[minI] = true;
				}
			}
			
			// 적 죽이기
			for(int i=newEnemy.size()-1;i>=0;i--) {
				if(die[i]) {
					newEnemy.remove(i);
					killCount++;
				}
			}
			
			// 적들 전진하기
			int i = 0;
			while(i<newEnemy.size()) {
				//전진하는데 N+1열 도달하면 제거
				if(newEnemy.get(i)[0]+1 == N) {
					newEnemy.remove(i);
					continue;
				}
				// 전진
				newEnemy.set(i, new int[] {newEnemy.get(i)[0]+1, newEnemy.get(i)[1]});
				i++;
			}
		}
		
		return killCount;
	}

	
	static int getDist(int[] o1, int[] o2) {
		return Math.abs(o1[0]-o2[0]) + Math.abs(o1[1]-o2[1]);
	}
}

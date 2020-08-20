package baekjoon;

import java.util.Scanner;

public class b14502 {
	public int safeMax = 0;
	public int b14502(int n, int m, int[][]map) {		
		dfs(n, m, map, 0, 0, 0);
		
		return this.safeMax;
	}
	
	public void dfs(int n, int m, int[][]map, int indexR, int indexC, int wallCount) {
		if(wallCount >= 3) {
			int[][] map2 = new int[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					map2[i][j] = map[i][j];
				}
			}

			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j] == 2) {
						//바이러스 위치부터 퍼지기
						map2 = spread(n, m, map2, i, j);
					}
					
				}
			}
			this.safeMax = Math.max(this.safeMax, countSafe(n, m, map2));
			return;
		}
		if(indexR >= n) return;

		
		int nextC = indexC;
		int nextR = indexR;
		//다음 인덱스
		if(indexC >= m-1) {
			nextR = indexR + 1;
			nextC = 0;
		}else {
			nextC = indexC + 1;
		}
		
		if(map[indexR][indexC] == 0) {
			//if(nextR <= n-1) {
				//벽 안세울 경우
				dfs(n, m, map, nextR, nextC, wallCount);
				
				//벽 세울 경우
				map[indexR][indexC] = 1;
				dfs(n, m, map,nextR, nextC, wallCount+1);
				map[indexR][indexC] = 0;
			//}
		}else {
			//if(nextR <= n-1) {
				//벽 안세울 경우
				dfs(n, m, map,nextR, nextC, wallCount);
			//}
		
		}
		
	}
	public int[][] spread(int n, int m, int[][]map, int indexR,int indexC){
		
		for(int i=indexR-1;i>=0;i--) {
			if(map[i][indexC] == 1) break;
			else if(map[i][indexC] == 0) {
				map[i][indexC] = 2;
				map = spread(n, m, map, i, indexC);
			}
		}
		for(int i=indexR+1;i<n;i++) {
			if(map[i][indexC] == 1) break;
			else if(map[i][indexC] == 0) {
				map[i][indexC] = 2;
				map = spread(n, m, map, i, indexC);
			}
		}
		for(int i=indexC-1;i>=0;i--) {
			if(map[indexR][i] == 1) break;
			else if(map[indexR][i] == 0) {
				map[indexR][i] = 2;
				map = spread(n, m, map, indexR, i);
			}
		}
		for(int i=indexC+1;i<m;i++) {
			if(map[indexR][i] == 1) break;
			else if(map[indexR][i] == 0) {
				map[indexR][i] = 2;
				map = spread(n, m, map, indexR, i);
			}
		}
		
		return map;
	}
	
	public int countSafe(int n, int m, int[][]map) {
		int count = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] == 0)
					count++;
			}
		}

		return count;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, m;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		int [][] map = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = s.nextInt();
			}
		}
		b14502 b = new b14502();
		System.out.println(b.b14502(n, m, map));
	}

}

package CodingTest.swexpert;
import java.io.*;
import java.util.*;
public class t_1953 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		int[][] dir = {{-1, 0},{0, 1},{1, 0},{0, -1}};
		int[][] pipe = {{}, {0, 1, 2, 3}, {0, 2}, {1, 3}, {0, 1}, {1, 2}, {3, 2}, {0, 3}};
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int [][] board = new int[N][M];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0;j<M;j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			boolean [][] visit = new boolean[N][M];
			Deque <int[]> queue = new ArrayDeque<>();
			queue.offer(new int[] {R, C, 0});
			visit[R][C] = true;
			
			int count = 0; // 맨홀 포함
			while(!queue.isEmpty()) {
				int [] q = queue.poll();
				//System.out.println(Arrays.toString(q));
				if(q[2] >= L) {
					break;
				}
				count++;
				int[] p = pipe[board[q[0]][q[1]]];
				for(int d=0;d<p.length;d++) {
					int newR = q[0] + dir[p[d]][0];
					int newC = q[1] + dir[p[d]][1];
					
					if(0<=newR && newR<N && 0<=newC &&newC<M) {
						if(!visit[newR][newC]) {
							// 가려는 파이프가 연결되어 잇어야 갈 수 있음
							boolean canGo = false;
							for(int i=0;i<pipe[board[newR][newC]].length;i++) {
								if((p[d]+2)%4 == pipe[board[newR][newC]][i]) {
									canGo = true;
								}
							}
							if(canGo) {
								queue.offer(new int[] {newR, newC, q[2]+1});
								visit[newR][newC] = true;
							}
							
						}
					}
				}
				
			}
			
			System.out.println("#"+tc+" "+count);
			
			
		}
	}

}

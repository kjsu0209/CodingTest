package CodingTest.swexpert;
import java.io.*;
import java.util.*;
public class t_2117 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] board = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0;j<N;j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int maxProfit = 0;
			int maxHome = 0;
			int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					//System.out.println(i+" - "+j);
					// bfs
					Deque <int[]> queue = new ArrayDeque<>();
					boolean[][] visit = new boolean[N][N];
					queue.offer(new int[] {i, j, 1}); // 1은 서비스 영역
					
					int home = 0;
					int profit = 0;
					int K = 1;
					visit[i][j] = true;
					
					while(!queue.isEmpty()) {
						int[] q = queue.poll();
						//System.out.println(Arrays.toString(q));
						
						// 서비스 확장 시 이익 체크
						if(K < q[2]) {
							
							if(profit-getOperPrice(K) >= 0 && maxHome < home) {
								maxHome = home;
							}
							K ++;
						}
						
						if(board[q[0]][q[1]] == 1) {
							home++;
							profit+=M;
						}
						
						// 다이아몬드 스텝으로 서비스
						for(int d=0;d<4;d++) {
							int newR = q[0]+direction[d][0];
							int newC = q[1]+direction[d][1];
							
							if(0<=newR&&newR<N && 0<=newC&&newC<N) {
								if(!visit[newR][newC]) {
									visit[newR][newC] = true;
									
									queue.offer(new int[] {newR, newC, q[2]+1});
								}
							}
						}
					}
					
					// 탐색 다 끝나고 한 번 더 검사
					if(profit-getOperPrice(K) >= 0 && maxHome < home) {
						maxHome = home;
					}
				}
			}
			
			System.out.println("#"+tc+" "+maxHome);
		}
	}
	
	static int getOperPrice(int k) {
		return (k*k) + ((k-1)*(k-1));
	}

}

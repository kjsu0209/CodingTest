// 1:00
// 
package swea;

import java.util.*;
import java.io.*;

public class sw_5653 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			String[] input = in.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			int K = Integer.parseInt(input[2]);

			int[][] status = new int[N+(2*K)][M+(2*K)]; // 0: 없음, 1: 비활성, 2: 활성, 3: 사망
			int[][] board = new int[N+(2*K)][M+(2*K)]; 
			int[][] hist = new int[N+(2*K)][M+(2*K)];  // 세포가 태어난 시간
			
			Deque<int[]> readyQueue = new ArrayDeque<>();
			for(int i=K;i<K+N;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j=K;j<K+M;j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if(board[i][j]>0) {
						status[i][j] = 1;
						readyQueue.offer(new int[] {i, j, board[i][j]}); // 좌표, 활성될때까지 남은 시간 
					}
				}
			}
			
			Deque<int[]> activeQueue = new ArrayDeque<>();
			int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상 우 하 좌
			for(int k=0;k<K;k++) {

				// 1. 활성된 것들 돌면서 번식시키기
				Deque<int[]> tempQ = new ArrayDeque<>();
				Deque<int[]> activeQ = new ArrayDeque<>();
				while(!activeQueue.isEmpty()) {
					int[] q = activeQueue.poll();
					
					if(q[2] == 0) {
						status[q[0]][q[1]] = 3;
						continue;
					}
					
					for(int[] d : dir) {
						int newR = q[0] + d[0];
						int newC = q[1] + d[1];
						
						if(0<=newR&&newR<N+(K*2)&&0<=newC&&newC<M+(K*2)) {
							if(hist[newR][newC] == k) {
								// 동시에 한 곳에 번식될 경우
								if(board[newR][newC] < q[2]) {
									board[newR][newC] = q[2];
								}
							}
							else if(hist[newR][newC] == 0 && status[newR][newC] == 0) {
								board[newR][newC] = q[2];
								status[newR][newC] = 1;
								hist[newR][newC] = k;
								tempQ.offer(new int[] {newR, newC, -1});
							}
						}
					}
					
					q[2] -= 1;
					activeQ.offer(q);
				}
				
				while(!activeQ.isEmpty()) {
					activeQueue.offer(activeQ.poll());
				}
				
				// 2. queue에 있는거 다 빼서 활성되는 것 찾기
				while(!readyQueue.isEmpty()) {
					int[] q = readyQueue.poll();
					q[2] -= 1;

					if(q[2] == 0) {
						q[2] = board[q[0]][q[1]];
						status[q[0]][q[1]] = 2;
						activeQueue.offer(q); // 좌표, 비활성될때까지 남은 시간
					}
					else {
						tempQ.offer(q);
					}
				}
				while(!tempQ.isEmpty()) {
					int[] q = tempQ.poll();
					if(q[2] == -1) {
						q[2] = board[q[0]][q[1]];
					}
					
					readyQueue.offer(q);
				}
				
//				System.out.println("****");
//				for(int[] arr : status) {
//					for(int a : arr) {
//						System.out.print(a + " ");
//					}
//					System.out.println();
//				}
				
			}
			
			int count = 0;
			
			while(!activeQueue.isEmpty()) {
				int[] q = activeQueue.poll();
				
				if(q[2] != 0) count++;
			}
			
			count+= readyQueue.size();
			
			System.out.println("#"+tc+" " + count);
			
		}
	}

}

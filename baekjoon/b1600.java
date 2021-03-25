package CodingTest.baekjoon;
import java.io.*;
import java.util.*;

public class b1600 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[H][W];
		
		for(int i=0;i<H;i++) {
			st = new StringTokenizer(in.readLine());
			
			for(int j=0;j<W;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Deque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {0, 0, 0, 0}); // r, c, k, 이동수
		
		boolean [][]visit = new boolean[H][W];
		visit[0][0] = true;
		
		int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상, 우, 하, 좌
		int[][] horseJump = {{-2, -1}, {-2, 1},{2, -1}, {2, 1}, {1, -2}, {-1, -2}, {1, 2}, {-1, 2}}; // 상, 우, 하, 좌
		
		int[][] memo = new int[H][W]; // 최소 이동거리 메모
		int[][] jumpHistory = new int[H][W]; // 최소 이동거리일 경우 점프 남은 횟수
		for(int i=0;i<H;i++) Arrays.fill(memo[i], Integer.MAX_VALUE);
		
		int result = -1;
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			//System.out.println(Arrays.toString(q));
			// 메모된 최소 이동거리보다 더 걸려서 해당 위치에 도착하면 back
			if(memo[q[0]][q[1]] < q[3] && jumpHistory[q[0]][q[1]] < q[2]) {
				//System.out.println("hi!");
				continue;
			}
			
			memo[q[0]][q[1]] = q[3];
			jumpHistory[q[0]][q[1]] = q[2];
			
			if(q[0] == H-1 && q[1] == W-1) {
				result = q[3];
				break;
			}
			
			for(int d=0;d<4;d++) {
				int newR = q[0]+direction[d][0];
				int newC = q[1]+direction[d][1];
				
				if(0<=newR && newR<H && 0<=newC && newC<W) {
					if(board[newR][newC] != 1) {
						queue.offer(new int[] {newR, newC, q[2], q[3]+1});
					}
				}
			}
			
			if(q[2] < K) {
				for(int d=0;d<8;d++) {
					int newR = q[0]+horseJump[d][0];
					int newC = q[1]+horseJump[d][1];
					
					if(0<=newR && newR<H && 0<=newC && newC<W) {
						if(board[newR][newC] != 1) {
							queue.offer(new int[] {newR, newC, q[2]+1, q[3]+1});
						}
					}
				}
			}
		}
		
		System.out.println(result);
		
	}

}

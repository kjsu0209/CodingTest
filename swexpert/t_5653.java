/*
 * test code
1
2 2 10
1 1
0 2
 */

package CodingTest.swexpert;
import java.io.*;
import java.util.*;
public class t_5653 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = stoi(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = stoi(st.nextToken());
			int M = stoi(st.nextToken());
			int K = stoi(st.nextToken());
			
			int[][] board = new int[N][M];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0;j<M;j++) {
					board[i][j] = stoi(st.nextToken());
				}
			}
			
			int[][] direction = {{-1, 0}, {1,0},{0,-1},{0,1}};
			PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) ->{
				
					return (o1[4] - o2[4]);
			});
			// 현재 활성화된 세포
			Map<String, int[]> active = new HashMap<>();
			
			for(int i=0;i<board.length;i++) {
				for(int j=0;j<board[0].length;j++) {
					if(board[i][j] > 0) {
						 // 좌표, 생명력 수치, 남은 활성 시간(음수: 비활성화, 양수:활성화 수치 넘음: 큐에 완전히 빼기), 총 시간
						queue.offer(new int[] {i, j, board[i][j], -board[i][j]+1, 0});
						active.put(i+"-"+j, new int[] {board[i][j], 0});
					}
				}
			}
			
			while(!queue.isEmpty()) {
				int[] q = queue.poll();
				System.out.println(Arrays.toString(q));
				// 사망
				if(q[3] == q[2]) {
					System.out.println("die");
					continue;
				}
				
				// K시간 도달
				if(q[4] == K-1)
					break;
				
				// 처음 활성화됐을 경우 동서남북으로 번식
				if(q[3] == 0) {
					for(int i=0;i<4;i++) {
						int newR = q[0]+direction[i][0];
						int newC = q[1]+direction[i][1];
						String s = newR+"-"+newC;
						if(active.containsKey(s)) {
							// 오래된 다른 세포가 선점
							if(active.get(s)[1] > q[4]) {
								continue;
							}
							// 태어난 시간이 같고 수치가 높은게 이미 존재하면 추가 x
							else if(active.get(s)[1] == q[4] && active.get(s)[0] >= q[3]) {
								continue;
							}
							else{
								queue.offer(new int[] {newR, newC, q[2], -q[2]+1, q[4]+1});
								active.put(s, new int[] {newR, newC, q[2], q[4]+1});
							}
						}else {
							queue.offer(new int[] {newR, newC, q[2], -q[2]+1, q[4]+1});
							active.put(s, new int[] {newR, newC, q[2], q[4]+1});
						}
						
					}
				}
				
				// 세포 시간 더하기
				queue.offer(new int[] {q[0], q[1], q[2], q[3]+1, q[4]+1});
				
			}
			
			// 죽은거 다빼기
			int count = 0;
			while(!queue.isEmpty()) {
				if(queue.peek()[2] == queue.peek()[3]) {
					queue.poll();
					continue;
				}
				count++;
				queue.poll();
			}
			
			System.out.println(count);
			
		}
		
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}

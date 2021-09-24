// 0:20
// bfs

package bj;
import java.io.*;
import java.util.*;

public class b2667 {
	
	public void solution() throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[][] places = new int[N][N];
		
		for(int i=0;i<N;i++) {
			char[] line = in.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				places[i][j] = (int)line[j] - 48;
			}
		}
		
		List<Integer> answer = new ArrayList<>();
		
		// bfs
		Deque<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		
		int count = 0;
		loop: for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(places[i][j] == 1) {
					queue.offer(new int[]{i, j});
					visited[i][j] = true;
					count++;
					break loop;
				}
			}
		}
		
		int [][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
		
		while(!queue.isEmpty()) {
			int[] q = queue.poll();

			for(int[] d : dir) {
				int newR = q[0]+d[0];
				int newC = q[1]+d[1];
				
				if(0<=newR && newR <N && 0<=newC && newC <N) {
					if(places[newR][newC] == 1 && !visited[newR][newC]) {
						queue.offer(new int[] {newR, newC});
						visited[newR][newC] = true;
						count++;
					}
				}
			}
			
			if(queue.isEmpty()) {
				answer.add(count);
				count = 0;				
				loop: for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(places[i][j] == 1 && !visited[i][j]) {
							queue.offer(new int[]{i, j});
							visited[i][j] = true;
							count++;
							break loop;
						}
					}
				}
			}
		}
		
		Collections.sort(answer);
		
		System.out.println(answer.size());
		for(int a : answer) {
			System.out.println(a);
		}
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		b2667 b = new b2667();
		b.solution();
	}

}

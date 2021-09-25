// 0:30
// Implementation + PriorityQueue

package bj;
import java.io.*;
import java.util.*;

public class b21608 {

	public void solution() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [][] info = new int[N*N][5];
		
		for(int i=0;i<N*N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0;j<5;j++) {
				int n = Integer.parseInt(st.nextToken());
				
				info[i][j] = n;
			}
		}
		
		int [][] place = new int[N][N];
		Map <Integer, int[]> loc = new HashMap<>();
		
		int [][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		for(int i=0;i<N*N;i++) {
			int student = info[i][0];
			
			// 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리 정하기
			// 2. 좋아하는 학생이 인접한 칸에 가장 많은 칸이 여러 개이면 비어있는 칸이 가장 많은 칸으로 자리 정하기
			// 3. 행 번호가 가장 작은 칸 찾고 그것도 여러 개이면 열의 번호가 가장 작은 칸
			// int[] -> {행, 열, 인접칸 좋아하는 학생 수, 비어있는 칸 수}
			PriorityQueue<int[]> queue = new PriorityQueue<>((int[] o1, int[] o2)->{
				if(o1[2] == o2[2]) {
					if(o1[3] == o2[3]) {
						if(o1[0] == o2[0]) {
							return o1[1] - o2[1];
						}
						else {
							return o1[0] - o2[0];
						}
					}
					else {
						return o2[3] - o1[3];
					}
				}
				else {
					return o2[2] - o1[2];
				}
			});
			
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(place[j][k] == 0) {
						int blank = 0;
						int friends = 0;
						for(int[] d: dir) {
							int newR = j + d[0];
							int newC = k + d[1];
							
							if(0<=newR && newR<N && 0<=newC && newC<N) {
								if(place[newR][newC] == 0) {
									blank ++;
									continue;
								}
								
								for(int f = 1; f<5; f++) {
									if(info[i][f] == place[newR][newC]) {
										friends++;
										break;
									}
								}
								
							}
						}
						queue.offer(new int[] {j, k, friends, blank});
					}
				}
			}
			
			int[] q = queue.poll();
			
			place[q[0]][q[1]] = student;
			loc.put(student, new int[] {q[0], q[1]});
			//System.out.println(student+" " + q[0] + "-"+q[1]);
		}
		
		// 만족도 총합 구하기
		int answer = 0;
		for(int i=0;i<N*N;i++) {
			int friends = 0;
			int[] location = loc.get(info[i][0]);
			for(int[] d: dir) {
				int newR = location[0] + d[0];
				int newC = location[1] + d[1];
				
				if(0<=newR && newR<N && 0<=newC && newC<N) {
					for(int f = 1; f<5; f++) {
						if(info[i][f] == place[newR][newC]) {
							friends++;
							break;
						}
					}
					
				}
			}
			
			//System.out.println(info[i][0] + ":" + friends);
			
			switch(friends) {
			case 1:
				answer += 1; break;
			case 2:
				answer += 10; break;
			case 3:
				answer += 100; break;
			case 4:
				answer += 1000; break;
			}
			
		}
		System.out.println(answer);
		
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		b21608 b = new b21608();
		b.solution();
	}

}

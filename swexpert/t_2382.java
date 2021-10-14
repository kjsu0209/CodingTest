// 0:51
package swea;

import java.util.*;
import java.io.*;

public class t_2382 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] queue = new int[K];
			int qSize = 0;
			
			int[][] map = new int[N][N];
			
			int[][] groups = new int[K+1][4]; // 행, 열, 미생물 수 , 이동 방향
			
			for(int i=1;i<=K;i++) {
				st = new StringTokenizer(in.readLine());
				groups[i][0] = Integer.parseInt(st.nextToken());
				groups[i][1] = Integer.parseInt(st.nextToken());
				groups[i][2] = Integer.parseInt(st.nextToken());
				groups[i][3] = Integer.parseInt(st.nextToken())-1;

				queue[qSize++] = i;
				map[groups[i][0]][groups[i][1]] = i;
			}
			
			for(int t=0;t<M;t++) {
				int tempSize = 0;
				// 움직이기
				Map<String, List<Integer>> places = new HashMap<>();

				for(int q=0;q<qSize;q++) {
					int idx = queue[q];
					
					// 이동
					groups[idx][0] += direction[groups[idx][3]][0];
					groups[idx][1] += direction[groups[idx][3]][1];
					
					// 벽에 부딪힐 경우
					if(!(1<=groups[idx][0]&&groups[idx][0]<N-1&&1<=groups[idx][1]&&groups[idx][1]<N-1)) {
						groups[idx][3] = reverseDir(groups[idx][3]);
						//System.out.println(groups[idx][2] +" <- pre");
						groups[idx][2] /= 2;
						//System.out.println(groups[idx][2] +" <- after");

					}
					if(groups[idx][2] == 0) {
						continue;
					}
					
					String loc = groups[idx][0] + "-" + groups[idx][1];
					if(places.containsKey(loc)) {
						places.get(loc).add(idx);
					}
					else {
						List<Integer> li = new ArrayList<>();
						li.add(idx);
						places.put(loc, li);
					}
				}
				
				for(Map.Entry<String, List<Integer>> entry : places.entrySet()) {
					int maxIdx = entry.getValue().get(0);
					int maxVal = groups[maxIdx][2];
					int totalVal = maxVal;
					for(int i=1;i<entry.getValue().size();i++) {
						if(maxVal < groups[entry.getValue().get(i)][2]) {
							maxIdx = entry.getValue().get(i);
							maxVal = groups[entry.getValue().get(i)][2];
						}
						totalVal += groups[entry.getValue().get(i)][2];
					}
					
					queue[tempSize++] = maxIdx;
					groups[maxIdx][2] = totalVal;
				}
				qSize = tempSize;
			}
			int total = 0;
			
			for(int i=0;i<qSize;i++) {
				total+=groups[queue[i]][2];
				//System.out.println(groups[queue[i]][2]);
			}
			
			System.out.println("#"+tc+" "+total);
			
		}
	}

	public static int reverseDir(int d) {
		if(d == 0 || d== 2) {
			return d+1;
		}
		else {
			return d-1;
		}
	}
}

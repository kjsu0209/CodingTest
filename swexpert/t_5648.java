// 3:12
// 큐 재활용...
package swea;

import java.io.*;
import java.util.*;

public class t_5648 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		int [][] map = new int[4002][4002];
		int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
		int [][] pop = new int[4002][4002];
		int[][] queue = new int[1000][2]; // 충돌이 발생한 위치 저장 큐
		int qSize= 0; // 큐 크기 
		int[][] atoms = new int[1001][5];
		
		int[] aliveQ = new int[1001];
		int aliveSize = 0;
		
		int tempQSize = 0;


		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(in.readLine());
			qSize = 0;
			

			for(int i=1;i<=N;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				atoms[i][0] = (Integer.parseInt(st.nextToken())*2)+2000;
				atoms[i][1] = (Integer.parseInt(st.nextToken())*2)+2000;
				atoms[i][2] = Integer.parseInt(st.nextToken());
				atoms[i][3] = Integer.parseInt(st.nextToken());
				atoms[i][4] = 1;//살아 있으면 1, 죽으면 0
				
				map[atoms[i][0]][atoms[i][1]] = i;
				aliveQ[aliveSize++] = i;
			}
			
			int answer = 0;
			
			for(int t=0;t<4002;t++) {
				for(int q=0;q<aliveSize;q++) {
					int i = aliveQ[q];
					if(atoms[i][4] == 0) continue;
					
					map[atoms[i][0]][atoms[i][1]] = 0;
					
					atoms[i][0] += direction[atoms[i][2]][0];
					atoms[i][1] += direction[atoms[i][2]][1];

					if(0<=atoms[i][0]&&atoms[i][0]<4002&&0<=atoms[i][1]&&atoms[i][1]<4002) {
						
						// 충돌 발생 감지
						if(pop[atoms[i][0]][atoms[i][1]]==0 && map[atoms[i][0]][atoms[i][1]] > 0) {
							pop[atoms[i][0]][atoms[i][1]] += atoms[map[atoms[i][0]][atoms[i][1]]][3];
							pop[atoms[i][0]][atoms[i][1]] += atoms[i][3];
							
							queue[qSize][0] = atoms[i][0];
							queue[qSize][1] = atoms[i][1];
							qSize++;
							
							// 사망 처리
							atoms[map[atoms[i][0]][atoms[i][1]]][4] = 0;
							atoms[i][4] = 0;
						}
						else if(pop[atoms[i][0]][atoms[i][1]]> 0 && map[atoms[i][0]][atoms[i][1]] > 0) {
							// 이미 충돌이 확인되었을 경우
							pop[atoms[i][0]][atoms[i][1]] += atoms[i][3];
							// 사망 처리
							atoms[i][4] = 0;
						}
						else {
							map[atoms[i][0]][atoms[i][1]] = i;
							aliveQ[tempQSize++] = i;
						}
					}
					else {
						atoms[i][4] = 0;
					}
				}
				
				aliveSize = tempQSize;
				tempQSize = 0;
				
				// 충돌난 부분 검사
				for(int i=0;i<qSize;i++) {
					answer += pop[queue[i][0]][queue[i][1]];
					
					map[queue[i][0]][queue[i][1]] = 0;
					pop[queue[i][0]][queue[i][1]] = 0;
				}
				qSize = 0;
			}
			System.out.println("#"+tc+" "+answer);
			
		}
	}

}

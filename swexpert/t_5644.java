// 0:53
package CodingTest.swexpert;
import java.util.*;
import java.io.*;
public class t_5644 {

	static class BatteryCharger{
		int posR;
		int posC;
		int coverage;
		int performance;
		public BatteryCharger(int posR, int posC, int coverage, int performance) {
			super();
			this.posR = posR;
			this.posC = posC;
			this.coverage = coverage;
			this.performance = performance;
		}
		
		public int canCharge(int row, int col) {
			if(Math.abs(row-posR) + Math.abs(col-posC) <= coverage) {
				return performance;
			}
			return 0;
		}
		
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			
			int [] moveA = new int[M];
			int [] moveB = new int[M];
			
			int[][] dir = {{0, 0},{-1, 0},{0, 1},{1, 0},{0, -1}}; //x 상 우 하 좌

			st = new StringTokenizer(in.readLine());
			for(int i=0;i<M;i++) moveA[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			for(int i=0;i<M;i++) moveB[i] = Integer.parseInt(st.nextToken());
			
			BatteryCharger[] BC = new BatteryCharger[A];
			for(int i=0;i<A;i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				BC[i] = new BatteryCharger(y, x, c, p);
			}
			
			int[] posA = new int[2];
			posA[0] = 0;
			posA[1] = 0;
			int[] posB = new int[2];
			posB[0] = 9;
			posB[1] = 9;
			
			int time = 0;
			int eSum = 0;
			while(time<=M) {
				//System.out.println("T "+time);
				// 사용할 수 있는 BC 찾기
				PriorityQueue<BatteryCharger> pqA = new PriorityQueue<>((o1, o2)->{
					return -(o1.performance - o2.performance);
				});
				for(int i=0;i<A;i++) {
					if(BC[i].canCharge(posA[0], posA[1]) > 0) {
						pqA.offer(BC[i]);
					}
				}
				PriorityQueue<BatteryCharger> pqB = new PriorityQueue<>((o1, o2)->{
					return -(o1.performance - o2.performance);
				});
				for(int i=0;i<A;i++) {
					if(BC[i].canCharge(posB[0], posB[1]) > 0) {
						pqB.offer(BC[i]);
					}
				}
				
				// 최대값인 BC를 공유할 경우
				int energy= 0;
				if(!pqA.isEmpty() && !pqB.isEmpty()) {
					if(pqA.peek().posR == pqB.peek().posR && pqA.peek().posC == pqB.peek().posC) {
						int maxP = 0;

						// 최대값 제외한 값 중 제일 큰 값
						maxP += pqA.poll().performance;
						pqB.poll();
						
						int share = maxP; // 최대값인 BC를 공유할 경우
						
						if(!pqA.isEmpty() && !pqB.isEmpty()) {
							if(pqA.peek().performance > pqB.peek().performance) {
								maxP += pqA.poll().performance;
							}else {
								maxP += pqB.poll().performance;
							}
						}else {
							if(!pqA.isEmpty()) {
								maxP += pqA.poll().performance;
							}
							else if(!pqB.isEmpty()) {
								maxP += pqB.poll().performance;
							}
						}
						
						
						if(share < maxP) {
							//System.out.print("최대값과 최대값을 제외한 값 중 제일 큰 값");
							energy = maxP;
						}else {
							//System.out.println(share + " 공유");
							energy = share;
						}
					}else {
						//각자 최대값인 BC 사용
						//System.out.print("각자 최대값인 BC 사용");
						energy += pqA.poll().performance;
						energy += pqB.poll().performance;
					}
				}
				else {
					//각자 최대값인 BC 사용
					//System.out.print("각자 최대값인 BC 사용");
					if(!pqA.isEmpty())
						energy += pqA.poll().performance;
					if(!pqB.isEmpty())
						energy += pqB.poll().performance;
				}
				//System.out.println(" : "+energy);
				eSum += energy;
				
				if(time == M) break;
				
				// 움직이기
				posA[0] += dir[moveA[time]][0];
				posA[1] += dir[moveA[time]][1];
				posB[0] += dir[moveB[time]][0];
				posB[1] += dir[moveB[time]][1];
				
				time++;
			}
			
			System.out.println("#"+tc+" "+eSum);
			
		}
	}

}

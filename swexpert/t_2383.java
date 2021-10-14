// 1:09
package swea;

import java.io.*;
import java.util.*;

public class t_2383 {
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(in.readLine());
			int[][] room = new int[N][N];
			List<int[]> stairs = new ArrayList<>();
			List<int[]> people = new ArrayList<>();
			
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j=0;j<N;j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
					if(room[i][j] == 1){
						people.add(new int[] {i, j});
					}
					else if(room[i][j] > 1) {
						stairs.add(new int[] {i, j});
					}
				}
			}
			
			int minTime = Integer.MAX_VALUE;
			for(int i=0;i<Math.pow(2, people.size());i++) {
				//System.out.println(Integer.toBinaryString(i));
				
				int time = simulate(N, room, stairs, people, i);
				minTime = Math.min(time, minTime);
			}
			
			System.out.println("#"+tc+" "+minTime);
		}
	}
	
	public static int simulate(int N, int[][] room, List<int[]> stairs, List<int[]> people, int dest) {
		
		
		// 사람별 도착지까지 걸리는 거리
		PriorityQueue<int[]> waitA = new PriorityQueue<>((int[] o1, int[] o2)-> {
			return o1[1] - o2[1];
		});
		PriorityQueue<int[]> waitB = new PriorityQueue<>((int[] o1, int[] o2)-> {
			return o1[1] - o2[1];
		});
		Deque<int[]> stairA = new ArrayDeque<>();
		Deque<int[]> stairB = new ArrayDeque<>();
		Deque<int[]> stairFrontA = new ArrayDeque<>();
		Deque<int[]> stairFrontB = new ArrayDeque<>();
		
		for(int i=0;i<people.size();i++) {
			if(((1<<i)&dest) == 0) {
				waitA.offer(new int[] {i+1, getDist(people.get(i), stairs.get(0)), 0}); // 사람 번호, 계단 도착 시간
			}
			else {
				waitB.offer(new int[] {i+1, getDist(people.get(i), stairs.get(1)), 0}); // 사람 번호, 계단 도착 시간
			}
		}
		
		int time = 0;
		int arrival = 0;
		
		while(arrival < people.size()) {
			//System.out.println("time - " + time + "/ arrival "+ arrival);
			// 계단 인원 내려가기
			while(!stairA.isEmpty() && stairA.peek()[1] == time) {
				//System.out.println(stairA.peek()[0] + " arrived the Dest");
				stairA.poll();
				arrival++;
			}
			while(!stairB.isEmpty() && stairB.peek()[1] == time) {
				//System.out.println(stairB.peek()[0] + " arrived the Dest");
				stairB.poll();
				arrival++;
			}
			
			if(arrival == people.size()) break;
			
			// 대기 인원 계단으로 가기
			int remainA = 3 - stairA.size();
			for(int i=0;i<remainA;i++) {
				if(!stairFrontA.isEmpty() && stairFrontA.peek()[2] <= time) {
					int[] q = stairFrontA.poll();
					q[1] = time + room[stairs.get(0)[0]][stairs.get(0)[1]];
					//System.out.println(q[0] + " down the stairB");

					stairA.offer(q);
				}
			}
			int remainB = 3 - stairB.size();
			for(int i=0;i<remainB;i++) {
				if(!stairFrontB.isEmpty() && stairFrontB.peek()[2] <= time) {
					int[] q = stairFrontB.poll();
					q[1] = time + room[stairs.get(1)[0]][stairs.get(1)[1]];
					//System.out.println(q[0] + " down the stairB");

					stairB.offer(q);
				}
			}
			
			// 계단 도착
			while(!waitA.isEmpty() && waitA.peek()[1] <= time) {
				int[] q = waitA.poll();
				q[2] = time + 1;
				//System.out.println(q[0] + " arrived the stairA");
				stairFrontA.offer(q);
			}
			while(!waitB.isEmpty() && waitB.peek()[1] <= time) {
				int[] q = waitB.poll();
				q[2] = time + 1;

				//System.out.println(q[0] + " arrived the stairB");
				stairFrontB.offer(q);
			}
			
			time++;
		}
		
		
		return time;
	}
	
	public static int getDist(int[] a, int[] b) {
		return Math.abs(a[0]-b[0]) + Math.abs(a[1] - b[1]);
	}

}

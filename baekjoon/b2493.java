package CodingTest.baekjoon;

import java.util.*;
import java.io.*;
public class b2493 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int [] towers = new int[N+1];

		Stack<int []> preTower = new Stack<>();
		for(int i=1;i<=N;i++) {
			preTower.push(new int[] {i, Integer.parseInt(st.nextToken())});
		}
		
		int[] towerReceiver = new int[N+1];
		Stack<int []> remainTower = new Stack<>();
		for(int i=0;i<N;i++) {
			// 스택에서 하나 빼기
			int[] s = preTower.pop();
			
			// 남아있는 게 있는지 확인
			if(remainTower.isEmpty()) {
				//없으면 바로 넣기
				remainTower.push(s);
				continue;
			}else {
				//있으면 비교
				while(!remainTower.isEmpty()) {
					if(remainTower.peek()[1] <= s[1]) {
						towerReceiver[remainTower.peek()[0]] = s[0];
						remainTower.pop();
					}else {
						break;
					}
				}
				remainTower.push(s);
			}
		}
		
		for(int i=1;i<=N;i++) {
			System.out.print(towerReceiver[i]+" ");
		}
		System.out.println();
	}

}

// 완탐+그리디
// 0:45
package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b2116 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int diceNum = stoi(in.readLine());
		int maxSum = 0;
		class Dice{
			int A, B, C, D, E, F; //위, 왼쪽, 앞, 오른쪽, 뒤, 아래

			public Dice(int a, int b, int c, int d, int e, int f) {
				super();
				A = a;
				B = b;
				C = c;
				D = d;
				E = e;
				F = f;
			}
			
			public void turn() {
				int temp = B;
				B = C;
				C = D;
				D = E;
				E = temp;
			}
			
			public void turnVer() {
				int temp = C;
				C = A;
				A = E;
				E = F;
				F = temp;
			}
			
			public void flip() {
				int temp = A;
				A = F;
				F = temp;
				// 옆면들 뒤집기
				temp = B;
				B = E;
				E = temp;
				temp = C;
				C = D;
				D = temp;
			}
			
			// n이 F에 와야 한다.
			public void adjust(int n) {
				// n이 a면 그냥 바꾸기
				if(n == A) {
					flip();
				}
				else if(n != F) {
					// C면이 n이 될때까지 돌리기
					for(int i=0;i<4;i++) {
						if(C == n) break;
						turn();
					}
					
					// 앞으로 돌리기
					turnVer();
				}
			}
		}
		
		

		Dice[] dices = new Dice[diceNum];
		for(int i=0;i<diceNum;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			dices[i] = new Dice(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()));
		}
		
		for(int i=1;i<=6;i++) {
			int sum = 0;
			int pre = -1; // 이전 주사위 윗면 저장
			for(int j=0;j<diceNum;j++) {
				Dice dice = dices[j];
				// 아랫면 맞추기
				if(pre != -1) {
					dice.adjust(pre);
				}
				else {
					// 처음 놓을 경우 
					dice.adjust(i);
				}
				pre = dice.A;
				
				// 옆면중 최댓값 구하기
				int maxNum = dice.C;
				for(int t=0;t<3;t++) {
					dice.turn();
					maxNum = Math.max(maxNum, dice.C);
				}
				
				
				//System.out.println(maxNum+ " top: "+dice.A+" bottom :"+dice.F);
				sum += maxNum;
			}
			maxSum = Math.max(maxSum, sum);
		}
		
		System.out.println(maxSum);
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}

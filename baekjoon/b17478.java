// -랑 _랑 구분하자 ㅠㅠ
// 0:12
package com.ssafy.swea;
import java.io.*;
public class Solution_bj_17478_재귀함수가뭔가요_구미_4_김정수 {
	
	public static void recur(int N, int depth) {
		
		for(int i=0;i<4*depth;i++) {
			System.out.print("_");
		}
		System.out.println("\"재귀함수가 뭔가요?\"");
		
		if(N == depth) {
			for(int i=0;i<4*(depth);i++) {
				System.out.print("_");
			}
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			for(int i=0;i<4*depth;i++) {
				System.out.print("_");
			}
			System.out.println("라고 답변하였지.");
			return;
		}
		for(int i=0;i<4*depth;i++) {
			System.out.print("_");
		}
		System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		for(int i=0;i<4*depth;i++) {
			System.out.print("_");
		}
		System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		for(int i=0;i<4*depth;i++) {
			System.out.print("_");
		}
		System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

		recur(N, depth+1);
		
		for(int i=0;i<4*depth;i++) {
			System.out.print("_");
		}
		System.out.println("라고 답변하였지.");
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		recur(N, 0);
	}

}

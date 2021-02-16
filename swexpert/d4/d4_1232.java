package CodingTest.swexpert.d4;
import java.util.*;
import java.io.*;
public class d4_1232 {
	
	static String[] tree;
	static int N;
	
	static void preOrder(int index) {
		// 리프노드거나 노드가 숫자면 그냥 돌아가기
		if(index*2+1 > N || isDigit(tree[index])) return;
		
		// 자식이 둘 다 숫자면 연산한 값 저장하기
		if(isDigit(tree[index*2]) && isDigit(tree[index*2+1])) {
			switch(tree[index]) {
				case "+":
					tree[index] = ""+(Integer.parseInt(tree[index*2]) + Integer.parseInt(tree[index*2+1]));
					break;
				case "-":
					tree[index] = ""+(Integer.parseInt(tree[index*2]) - Integer.parseInt(tree[index*2+1]));
					break;
				case "*":
					tree[index] = ""+(Integer.parseInt(tree[index*2]) * Integer.parseInt(tree[index*2+1]));
					break;
				case "/":
					tree[index] = ""+(Integer.parseInt(tree[index*2]) / Integer.parseInt(tree[index*2+1]));
					break;
			}
		}else {
			//연산자인 자식으로 재귀 호출
			if(!isDigit(tree[index*2])) preOrder(index*2);
			if(!isDigit(tree[index*2+1])) preOrder(index*2+1);
			
			// 호출 후 자식들 연산한 값 저장하기
			switch(tree[index]) {
				case "+":
					tree[index] = ""+(Integer.parseInt(tree[index*2]) + Integer.parseInt(tree[index*2+1]));
					break;
				case "-":
					tree[index] = ""+(Integer.parseInt(tree[index*2]) - Integer.parseInt(tree[index*2+1]));
					break;
				case "*":
					tree[index] = ""+(Integer.parseInt(tree[index*2]) * Integer.parseInt(tree[index*2+1]));
					break;
				case "/":
					tree[index] = ""+(Integer.parseInt(tree[index*2]) / Integer.parseInt(tree[index*2+1]));
					break;
			}
		}
	}
	
	static boolean isDigit(String s) {
		if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")) {
			return false;
		}else {
			return true;
		}
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1;tc<=10;tc++) {
			N = Integer.parseInt(in.readLine());
			tree = new String[N+1];
			StringTokenizer st;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(in.readLine());
				int index = Integer.parseInt(st.nextToken());
				tree[index] = st.nextToken();
				if(!isDigit(tree[index])) {
					st.nextToken();
					st.nextToken();
				}
			}
			
			// 전위순회 dfs로 연산
			preOrder(1);
			
			System.out.println("#"+tc+" "+ tree[1]);
		}
	}

}

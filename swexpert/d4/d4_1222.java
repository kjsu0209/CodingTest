package CodingTest.swexpert.d4;
import java.util.*;
import java.io.*;
/*
 * <후위표기법 만드는법>

1) 수식 문자열에서 문자 하나씩 빼서 확인한다.
2) 문자가 숫자면 StringBuffer에 붙인다.
3) 문자가 연산자면
-> 우선순위가 자신보다 낮은 연산자가 스택 top에 올 때까지 스택을 pop한다.
-> pop한걸 StringBuffer에 붙인다.
-> 다하면 연산자를 push한다.

 * */
public class d4_1222 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
			int N = Integer.parseInt(in.readLine());
			String input = in.readLine();
			StringBuilder sb = new StringBuilder();
			Stack<Character> stack = new Stack<>();
			for(int i=0;i<N;i++) {
				char c = input.charAt(i);
				
				if(c == '+') {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					stack.push(c);
				}else {
					sb.append(c);
				}
			}
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}

			input = sb.toString();
			Stack<Integer>value = new Stack<>();
			for(int i=0;i<N;i++) {
				char c = input.charAt(i);
				
				if(c == '+') {
					value.push(value.pop() + value.pop());
				}
				else {
					value.push(Integer.parseInt(c+""));
				}
			}
			System.out.println("#"+tc+" " + value.pop());
		}
		
		
	}

}

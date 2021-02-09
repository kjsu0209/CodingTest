package CodingTest.swexpert.d4;
import java.io.*;
import java.util.*;
public class d4_1224 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
			int N = Integer.parseInt(in.readLine());
			String input = in.readLine();
			
			Stack<Character> stack = new Stack<>();
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<N;i++) {
				char c = input.charAt(i);
				
				if(c == '+') {
					while(!stack.isEmpty()) {
						if(stack.peek() != '(') {
							sb.append(stack.pop());
						}else {
							break;
						}
					}
					stack.push(c);
				}
				else if(c == '*') {
					if(!stack.isEmpty()) {
						if(stack.peek() != '+' && stack.peek() != '(') {
							sb.append(stack.pop());
						}
					}
					stack.push(c);
				}
				else if(c == '(') {
					stack.push(c);
				}
				else if(c == ')') {
					while(!stack.isEmpty()) {
						if(stack.peek() != '(') {
							sb.append(stack.pop());
						}else{
							stack.pop();
							break;
						}
					}
				}
				else {
					sb.append(c + "");
				}
			}
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
//			System.out.println(sb);
			
			Stack<Integer> value = new Stack<>();
			input = sb.toString();
			for(int i=0;i<input.length();i++) {
				char c = input.charAt(i);
				
				if(c == '+') {
					value.push(value.pop() + value.pop());
				}
				else if(c == '*') {
					value.push(value.pop()*value.pop());
				}
				else {
					value.push(Integer.parseInt("" + c));
				}
			}
			
			System.out.println("#"+tc+" " + value.pop());
		}
	}

}

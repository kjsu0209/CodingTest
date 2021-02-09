package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b2504_2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<String> stack = new Stack<>();
		String input = in.readLine();
		int result = 0;
		boolean isValid = true;
		for(int i=0;i<input.length();i++) {
			char c = input.charAt(i);
			
			if(c == '(') {
				stack.push("(");
			}
			else if(c == '[') {
				stack.push("[");
			}
			else if(c == ')') {
				int v = 2;
				int r = 0;
				while(!stack.isEmpty()) {
					if(stack.peek() == "(") {
						stack.pop();
						v *= r;
						if(v == 0) v = 2;
						stack.push(v+"");
						break;
					}
					else {
						if(stack.peek().equals("[") || stack.peek().equals("]") || stack.peek().equals(")")) {
							isValid = false;
							break;
						}
						else {
							r += Integer.parseInt(stack.pop());
						}
					}
				}
			}
			else if(c == ']') {
				int v = 3;
				int r = 0;
				while(!stack.isEmpty()) {
					if(stack.peek() == "[") {
						stack.pop();
						v *= r;
						if(v == 0) v = 3;
						stack.push(v+"");
						break;
					}
					else {
						if(stack.peek().equals("(") || stack.peek().equals("]") || stack.peek().equals(")")) {
							isValid = false;
							break;
						}
						else {
							r += Integer.parseInt(stack.pop());
						}
					}
				}
			}
		}
		
		while(!stack.isEmpty()) {
			if(stack.peek().equals("(") || stack.peek().equals(")") || stack.peek().equals("[") || stack.peek().equals("]") ) {
				isValid = false;
				break;
			}
			result += Integer.parseInt(stack.pop());
		}
		if(!isValid)
			result = 0;
		System.out.println(result);
	}

}

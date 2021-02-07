package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b2504 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> charStack = new Stack<>();
		Stack<Integer> valueStack = new Stack<>(); // 중첩되는 값
		Stack<Integer> plusStack = new Stack<>(); // 나열되는 값
		int value = 0;
		boolean isValid = true;
		
		String input = in.readLine();
		
		for(int i=0;i<input.length();i++) {
			char c = input.charAt(i);
			
			if(c == '(') {
				charStack.push(c);
			}
			else if(c == '[') {
				charStack.push(c);
			}
			else if(c == ')' || c == ']') {
				int addVal = c == ')' ? 2:3;
				
				if(!charStack.isEmpty()) {
					if((addVal == 2 && charStack.peek() == '[') || (addVal == 3 && charStack.peek() == '(')) {
						isValid = false;
						break;
					}
					charStack.pop();
					
				}
				else {
					isValid = false;
					break;
				}
				// 괄호 끝났을 때
				// 괄호 스택 비었는지 확인
				if(charStack.isEmpty()) {
					// 비었으면 괄호가 끝난 것을 의미
					int sum = 0;
					
					// 중첩에 있던거 다 나열에 넣기
					
					while(!valueStack.isEmpty()) {
						if(sum == 0) {
							sum = valueStack.pop();
						}else {
							sum *= valueStack.pop();
						}
					}
					
					plusStack.push(sum);

					sum = 0;
					// 나열 스택에 있던거 다 더하기
					while(!plusStack.isEmpty()) {
						sum += plusStack.pop();
					}
					// 더한거 * addVal해서 value에 더하기
					if(sum > 0) {
						value += sum*addVal;
					}else {
						value+=addVal;
					}
				}
				else {
					// 안비었으면 다음괄호 확인
					if(i < input.length()-1) {
						if(input.charAt(i+1) == '(' || input.charAt(i+1) == '[') {
							// 다음괄호가 열렸으면
							// 중첩에 addVal 넣고 계산하기
							int sum = addVal;
							while(!valueStack.isEmpty()) {
								sum *= valueStack.pop();
							}
							// 계산한걸 나열 스택에 넣기
							plusStack.push(sum);
						}else {
							//닫혔으면
							int sum = addVal;
							while(!plusStack.isEmpty()) {
								sum+= plusStack.pop();
							}
							// 나열된거 다 더해서
							// 중첩에 몽땅 넣기
							valueStack.push(sum);
						}
					}else {
						// 안닫히고 종료하면 비정상
						isValid = false;
						break;
					}
				}
			}
		}
		
		
		if(isValid && charStack.isEmpty()) {
			System.out.println(value);
		}else {
			System.out.println(0);
		}
		
	}

}

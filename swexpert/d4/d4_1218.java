package CodingTest.swexpert.d4;

import java.io.*;
import java.util.*;
public class d4_1218 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char [][]brackets = new char[][] {{'(',')'}, {'[',']'}, {'{','}'}, {'<','>'} };

		for(int tc=1;tc<=10;tc++) {
			Stack<Character> stack = new Stack<>();
			int N = Integer.parseInt(in.readLine());
			String s = in.readLine();
			char c = ' ';
			for(int i=0;i<N;i++) {
				c = s.charAt(i);
				
				if(stack.isEmpty()) {
					stack.add(c);
				}else {
					boolean hasPopped = false;
					for(int j=0;j<4;j++) {
						if(brackets[j][1] == c) {
							if(stack.peek() == brackets[j][0]) {
								stack.pop();
								hasPopped = true;
								break;
							}
						}
					}
					if(!hasPopped) {
						stack.add(c);
					}
				}
			}
			
			if(stack.isEmpty()) {
				System.out.println("#"+tc+" 1");
			}else {
				System.out.println("#"+tc+" 0");
			}
			
		}
	}

}

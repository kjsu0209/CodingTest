// 0:08
// Stack
import java.util.*;

class Brackets {
    public int solution(String S) {
        // write your code in Java SE 8
        Stack <Character> stack = new Stack<>();
        int answer = 1;

        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);

            if(c == '{' || c =='(' || c=='['){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    answer = 0;
                    break;
                }
                if(c == '}'){
                    if(stack.peek() != '{'){
                        answer = 0;
                        break;
                    }
                    else{
                        stack.pop();
                    }
                }
                else if(c == ')'){
                    if(stack.peek() != '('){
                        answer = 0;
                        break;
                    }
                    else{
                        stack.pop();
                    }
                }
                else if(c == ']'){
                    if(stack.peek() != '['){
                        answer = 0;
                        break;
                    }
                    else{
                        stack.pop();
                    }
                }
            }
        }

        if(stack.size() > 0){
            answer = 0;
        }

        return answer;
    }
}

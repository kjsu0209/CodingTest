package programmers;
import java.util.*;

public class p60058 {
    public String solution(String p) {
        String answer = "";
        
        if(p.length() != 0){
            answer = make(p);
        }
        return answer;
    }
    
    public String make(String w){
        String u="", v="";
        //분리
        int countL = 0;
        int countR = 0;
        for(int i=0;i<w.length();i++){
            if(w.charAt(i)=='('){
                countL++;
            }else{
                countR++;
            }
            if(i!=0 && (countL == countR) && i!=w.length()-1){
                u = w.substring(0, i+1);
                v = w.substring(i+1);
                break;
            }
            else if(i == w.length()-1){
                u = w;
                v = "";
                break;
            }
        }
        
        System.out.println(u + "/" +v);
        StringBuffer newU = new StringBuffer();
        if(u.length()>0){
            if(check(u)){
                newU.append(u + make(v));
            }else{
                newU.append("(" + make(v) + ")");
                newU.append(reform(u));
            }
            return newU.toString();
        }else{
            return "";
        }
        
    }
    
    public String reform(String u){
        //괄호 뒤집기
        StringBuffer bf = new StringBuffer();
        for(int i=1;i<u.length()-1;i++){
            if(u.charAt(i) == '('){
                bf.append(')');
            }else{
                bf.append('(');
            }
        }
        return bf.toString();
    }
    
    public boolean check(String p){
        if(p.charAt(0) == '(' && p.charAt(p.length()-1) ==')'){
            return true;
        }
        else{
            return false;
        }
   
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		p60058 p = new p60058();
		String str = s.nextLine();
		System.out.println(p.solution(str));
	}

}

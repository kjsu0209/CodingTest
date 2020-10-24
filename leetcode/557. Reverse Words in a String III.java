import java.util.*;
class Solution {
    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(s, " ");
        
        while(st.hasMoreTokens()){
            String s1= st.nextToken();
            sb.append(reverseString(s1));
            if(st.hasMoreTokens()){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    
    public String reverseString(String s){
        if(s.length() == 1){
            return s;
        }
        return reverseString(s.substring(1)) + s.substring(0, 1);
    }
}

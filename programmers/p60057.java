import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        int strlen = 0;
        for(int i=1;i<s.length();i++){
            strlen = shrink(s, i);
            answer = Math.min(strlen, answer);
        }
        return answer;
    }
    
    public int shrink(String s, int n){
        //System.out.println(n);
        List<String> list = new ArrayList();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++){
            if(i+1<n){
                sb.append(s.charAt(i));
            }
            else if(i+1>n && (i+1)%n > 0){
                sb.append(s.charAt(i));
            }
            else{
                sb.append(s.charAt(i));
                String str = sb.toString();
                list.add(str);
                sb.setLength(0);
            }
        }
        list.add(sb.toString());
        
        int counter = 0;
        String pre = "";
        sb.setLength(0);
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String str = it.next();

            if(pre.equals(str)){
                counter ++;
            }else{
                if(pre.length() > 0){
                    if(counter>1)
                        sb.append(""+counter+pre);
                    else
                        sb.append(pre);
                    if(str.length()<n){
                        sb.append(str);
                    }
                }
                pre = str;
                counter = 1;
            }
        }
        String result = sb.toString();
                        //System.out.println(result);
        return result.length();
    }
}

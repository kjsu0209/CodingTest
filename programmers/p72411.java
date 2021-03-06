// 0:58
// 부분집합 문제
// 각 order에서 부분집합 구하고 등장 횟수 정렬해서 course 길이별 최대로 등장한 문자열 넣기(등장횟수 같을 경우 2개 이상 넣을 수 잇게)
import java.util.*;
class Solution {
    public String[] solution(String[] orders, int[] course) {
        HashMap <String, Integer> table = new HashMap<>();
        for(int i=0;i<orders.length;i++){
            String order = orders[i];
            StringBuilder sb = new StringBuilder();
            // 각 order에서 부분집합 구하기
            for(int j=0;j<Math.pow(2,order.length());j++){ ///j = flag
                sb.setLength(0);
                for(int k=0;k<order.length();k++){
                    if((j & (1<<k))!= 0){
                        sb.append(""+order.charAt(k));
                    }
                }
                
                if(sb.length() < 2){
                    continue;
                } 
                
                boolean flag = false;
                for(int c: course){
                    if(sb.length() == c) flag = true;
                }
                if(!flag) continue;
                
                char[] c = sb.toString().toCharArray();
                Arrays.sort(c);
                String s = new String(c);
                
                if(table.containsKey(s)){
                    table.put(s, table.get(s)+1);
                }else{
                    table.put(s, 1);
                }
            
            }
        }
                   
        // 정렬   
        ArrayList<String> ansArr = new ArrayList<>();
        for(String o: table.keySet()){
            if(table.get(o) < 2) continue;
            ansArr.add(o);
        }
        Collections.sort(ansArr, (o1, o2)->{
            return o1.length()== o2.length() ? o1.compareTo(o2): o1.length()- o2.length();
        });
        
        
        ArrayList<String> ansArr2 = new ArrayList<>();
        for(int c: course){
            int maxVal = -1;
            ArrayList<String> maxIndex = new ArrayList<>();
            for(String s: ansArr){
                if(s.length() != c) continue;
                if(maxVal < table.get(s)){
                    maxVal = table.get(s);
                    maxIndex = new ArrayList<>();
                    maxIndex.add(s);
                }
                else if(maxVal == table.get(s)){
                    maxIndex.add(s);
                }
            }
            
            for(String s : maxIndex){
                ansArr2.add(s);
            }
        }
        
        Collections.sort(ansArr2);
        
        String []answer = new String[ansArr2.size()];
        answer = ansArr2.toArray(answer);
        //System.out.println(ansArr2);
        return answer;
    }
}

// 0:07
// HashMap으로 인원 count
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap();
        
        for(String c: completion){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else{
                map.put(c, 1);
            }
        }
        
        for(String p: participant){
            if(!map.containsKey(p)){
                answer = p;
                break;
            }
            else{
                if(map.get(p) == 0){
                    answer = p;
                    break;
                }
                else{
                    map.put(p, map.get(p)-1);
                }
            }
        }
        
        return answer;
    }
}

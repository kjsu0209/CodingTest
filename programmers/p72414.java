// 초를 배열로 만들고 각 초마다 시청자 수 넣어줌
// 그리고 구간합 최대값 찾기 수행
// 1:00
import java.util.*;
class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(adv_time, ":|-");
        int adTime = Integer.parseInt(st.nextToken()) * 3600;
        adTime += Integer.parseInt(st.nextToken()) * 60;
        adTime += Integer.parseInt(st.nextToken());

        st = new StringTokenizer(play_time, ":|-");
        int playTime = Integer.parseInt(st.nextToken()) * 3600;
        playTime += Integer.parseInt(st.nextToken()) * 60;
        playTime += Integer.parseInt(st.nextToken()) + 1;
        
        StringBuilder [] quantom = new StringBuilder[playTime];
        for(int logId=0;logId<logs.length;logId++){
            st = new StringTokenizer(logs[logId], ":|-");
            int start = Integer.parseInt(st.nextToken()) * 3600;
            start += Integer.parseInt(st.nextToken()) * 60;
            start += Integer.parseInt(st.nextToken());
            
            int end = Integer.parseInt(st.nextToken()) * 3600;
            end += Integer.parseInt(st.nextToken()) * 60;
            end += Integer.parseInt(st.nextToken());
            
            if(quantom[start] == null){
                quantom[start] = new StringBuilder();
            }
            if(quantom[end] == null){
                quantom[end] = new StringBuilder();
            }
            quantom[start].append(""+logId+"-"+0+",");
            quantom[end].append(""+logId+"-"+1+",");   
        }
        
        long [] watchers = new long[playTime];
        long watcher = 0; // 현재 시간 시청자
        
        for(int i=0;i<playTime;i++){
            //quantom읽어서 log 0나오면 시청자 올리고 1나오면 시청자 내리기
            if(quantom[i] == null){
                watchers[i] = watcher;
                continue;
            }
            st = new StringTokenizer(quantom[i].toString(), "-|,");
            while(st.hasMoreTokens()){
                st.nextToken();
                if(Integer.parseInt(st.nextToken()) == 0){
                    // 시작: 시청자 올리기
                    ++watcher;
                }
                else{
                    // 종료: 시청자 내리기
                    --watcher;
                }
            }
            // watchers 배열에 해당 시간의 시청자 정보 넣기
            watchers[i] = watcher;
            
        }
        // watchers 배열 구간합 최대 구간 구하기
        int wIndex = 0;
        long sum = 0;
        for(int i=0;i<adTime;i++) sum += watchers[i];
        
        int maxWatcherIndex = 0; // 가장 인기있는 시간
        long maxWatcherNum = sum; //가장 인기 있는 시간 시청자 수
        while(wIndex < watchers.length-adTime){
            sum -= watchers[wIndex];
            ++wIndex;
            sum+= watchers[wIndex+adTime-1];
            if(sum > maxWatcherNum){
                maxWatcherNum = sum;
                maxWatcherIndex = wIndex;
            }
        }
        
        //maxWatcherIndex를 다시 문자열로 반환
        StringBuilder sb = new StringBuilder();
        long hour = maxWatcherIndex/3600;
        long min = (maxWatcherIndex%3600)/60;
        long sec = (maxWatcherIndex%3600)%60;
        
        if(hour < 10) sb.append("0");
        sb.append(hour+":");
        if(min < 10) sb.append("0");
        sb.append(min+":");
        if(sec < 10) sb.append("0");
        sb.append(sec+"");
        
        answer = sb.toString();
        return answer;
    }
}

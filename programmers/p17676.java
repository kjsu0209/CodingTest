import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.Calendar;
import java.util.*;
class Solution {
    public static class LogDate{
        public Date startDate;
        public Date endDate;
        public int count = 1;
        public int startC = 0;
        public int endC = 0;
        
        public LogDate(Date s, Date e){
            startDate = s;
            endDate = e;
        }
        
    }
    public int solution(String[] lines) {
        int answer = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date endLog = null;
        Date startLog = null;
        List <LogDate> logList = new ArrayList();

        int count = 1;
        int maxcount = 0;
        Calendar cal = Calendar.getInstance();
        Map <String, Integer> endhash = new HashMap();
        Map <String, Integer> starthash = new HashMap();
        try{

        for(int i = 0;i<lines.length;i++){
            String str = lines[i].substring(0, 23);
            String[] exeTime = lines[i].substring(24, lines[i].length()-1).split("\\.");
            Date date;
                date = dateFormat.parse(str);
                cal.setTime(date);
                //System.out.println(dateFormat.format(date));
                 //시작지점
                int exeMil = 0;
                if(exeTime.length > 1){
                    exeMil = Integer.parseInt(exeTime[1]);
                }
                cal.add(Calendar.MILLISECOND, exeMil*-1 + 1);
                
                int exeSec = Integer.parseInt(exeTime[0]);
                cal.add(Calendar.SECOND, exeSec*-1);
                
                startLog = dateFormat.parse(dateFormat.format(cal.getTime()));

                logList.add(new LogDate(startLog, date));
            
        }
        for(LogDate logD : logList){
             for(LogDate lo : logList){
                Date sDate = lo.startDate;
                Date eDate = lo.endDate;
                // 시작 지점이 실행기간 안에 포함될 경우
                if(logD.startDate.getTime()+999>=sDate.getTime() && logD.startDate.getTime()<=eDate.getTime()){
                   logD.startC++; 
                }
                // 끝 지점이 실행기간 안에 포함될 경우
                if(logD.endDate.getTime()+999>=sDate.getTime() && logD.endDate.getTime()<=eDate.getTime()){
                   logD.endC++; 
                }
                maxcount = Math.max(logD.startC, maxcount);
                maxcount = Math.max(logD.endC, maxcount);
            }
        }
        }catch(ParseException e){
        }
        answer = maxcount;
        return answer;
    }
}

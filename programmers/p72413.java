// 1:20
/*
1차: 다익스트라로 풀다가 시간초과
2차: 플로이드로 풀다가 바깥 for문을 중간값으로 안해줘서 fail (뭔 정신인지 i, j, k로 함ㅋㅋㅋ)
3차: 플로이드 3중포문을 k, i, j로 해주니 성공!
다익스트라는 구현에 따라 최대 O( N * ElogN )이 걸릴 수도 있고, 최소 O( 3 * ElogN )의 시간이 걸릴 수도 있음. 시간 초과 발생 가능성이 있는 것은 전자의 경우이므로 전자를 고려
---------------------------------------------
플로이드: O( N3 ) = 8 * 10^6
다익스트라: O( N * ElogN ) = 3 * 10^7
*/
import java.util.*;
class Solution {
    int inf = Integer.MAX_VALUE;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        inf = Integer.MAX_VALUE;
        ArrayList<int[]> roads[] = new ArrayList[n+1];
  
        answer = (int)floydFare(n, s, a, b, fares);
        
        
        return answer;
    }
    // floyd
    public long floydFare(int n, int s, int a, int b, int[][]fares){
        long[][]dist = new long[n+1][n+1];
        for(int i=0;i<dist.length;i++) Arrays.fill(dist[i], inf);
        
        for(int i=0;i<fares.length;i++){
            dist[fares[i][0]][fares[i][1]] = fares[i][2];
            dist[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        for(int i=0;i<dist.length;i++){
            dist[i][i] = 0;
        }
        
        for(int k=1;k<dist.length;k++){
            for(int i=1;i<dist.length;i++){
                for(int j=1;j<dist.length;j++){
                    if(dist[i][k] == inf || dist[k][j] == inf) continue;
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                        dist[j][i] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        long minF = inf;
        // 합승하지 않을 때
        if(dist[s][a] != inf && dist[s][b] != inf){
            minF = dist[s][a] + dist[s][b];
        }
        for(int i=1;i<dist.length;i++){
            if(dist[s][i]==inf || dist[i][a]==inf || dist[i][b]==inf) continue;
            long f = dist[s][i] + dist[i][a] + dist[i][b];
            //System.out.println(s+"->"+i+"->("+a+","+b+") : " + dist[s][i] + "+"+dist[i][a]+"+" +dist[i][b]+" = "+ f);
            minF = Math.min(minF, f);
        }
        
        return minF;
    }
 
}

import java.io.*;
import java.util.*;
public class Solution {
 
    static int N, M, C;
    static int[][] board;
    static int[][] startPoints;
    static boolean[][] visited;
    static int maxProfit;
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(in.readLine());
         
        for(int tc=1;tc<=T;tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
             
            board = new int[N][N];
            startPoints = new int[2][2];
            visited = new boolean[N][N];
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(in.readLine());
                for(int j=0;j<N;j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            // 벌통 시작 위치 2개 조합
            maxProfit = 0;
            selectStartPoints(0, 0, 0);
             
            System.out.println("#"+tc+" "+maxProfit);
             
        }
         
    }
     
    public static void selectStartPoints(int cnt, int indexR, int indexC) {
        if(cnt == 2) {
            // 다 뽑았을 경우 각 시작 위치의 가로줄에서 얻을 수 있는 최대 수익 계산
            int aVal = getMaxProfit(startPoints[0]);
            int bVal = getMaxProfit(startPoints[1]);
             
            //System.out.println(aVal + " "+ bVal);
            maxProfit = Math.max(maxProfit, aVal+bVal);
             
            return;
        }
         
        int r = indexR;
        int c = indexC;
        if(r==N-1 && c == N-1) {
            return;
        }
         
        while(r<N && c<N) {
            if(!visited[r][c] && isValidPos(cnt, r, c)) {
                startPoints[cnt][0] = r;
                startPoints[cnt][1] = c;
                visited[r][c] = true;
                selectStartPoints(cnt+1, r, c);
                visited[r][c] = false;
            }
             
            // 다음 칸으로 이동
            if(c == N-1) {
                r++;
                c = 0;
            }else {
                c++;
            }
        }
    }
     
     
    public static boolean isValidPos(int cnt, int r, int c) {
        // 시작위치 행+M이 범위 안에 들어가는지 확인
        if(c+M > N) {
            return false;
        }
        // 이미 하나가 먼저 선택되었을 경우 겹치는지도 확인
        if(cnt == 1) {
            if(startPoints[0][0] == r && ((startPoints[0][1] <= c && c <= startPoints[0][1]+M-1) || (startPoints[0][1] <= c+M-1 && c+M-1 <= startPoints[0][1]+M-1))) {
                return false;
            }
        }
         
         
         
        return true;
    }
 
 
    public static int getMaxProfit(int[] startPoint) {
        int profit = 0;
        // 부분집합 구해서 각 부분집합의 최대 값 확인
        for(int f=0;f<Math.pow(2, M);f++) {
            profit = Math.max(profit, getProfit(f, startPoint));
        }
         
        return profit;
    }
     
    public static int getProfit(int flag, int[] startPoint) {
        int profit = 0;
        int limit = 0;
        for(int i=0;i<M;i++) {
            if((flag & 1<<i) != 0) {
                // 각 용기에 있는 꿀의 양의 제곱만큼 수익
                profit += Math.pow(board[startPoint[0]][startPoint[1]+i], 2);
                limit += board[startPoint[0]][startPoint[1]+i];
            }
        }
         
        if(limit > C) {
            return 0;
        }
        else {
            return profit;
        }
    }
}
About

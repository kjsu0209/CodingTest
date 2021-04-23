// 0:48
// recursive + greedy
import java.io.*;
import java.util.*;
public class Solution {
 
    static int N;
    static char[][] board;
    static int result;
    static boolean[][] visit;
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(in.readLine());
         
        for(int tc=1;tc<=T;tc++) {
            N = Integer.parseInt(in.readLine());
            board= new char[N][N];
            for(int i=0;i<N;i++) {
                board[i] = in.readLine().toCharArray();
            }
            result = 0;
             
             
            // 지뢰 없는칸을 모두 계산 후 표시
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(board[i][j] == '*') continue;
                    board[i][j] = (char)getNearBombNum(i, j);
                    result++;
                }
            }
             
            // 보드를 한 번 더 순회하면서 8방향 모두 지뢰 없는 칸에 영향받는 칸의 수만큼 result 감소
            visit= new boolean[N][N];
 
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(board[i][j] == (char)0 && !visit[i][j]) {
                        visit[i][j] = true;
                        popping(i, j);
                         
                    }
                }
            }
             
            System.out.println("#"+tc+" "+result);
        }
    }
     
    public static void popping(int i, int j) {
        int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for(int d=0;d<8;d++) {
            int newR = i+dir[d][0];
            int newC = j+dir[d][1];
             
            if(0<=newR && newR<N && 0<=newC && newC<N) {
                if(!visit[newR][newC]) {
                    visit[newR][newC] = true;
                    // 연달아 터지는 구역도 폭탄 0개면 dfs 호출
                    if(board[newR][newC] == (char)0) {
                        popping(newR, newC);
                    }
                    result--;
                }
            }
        }
    }
     
     
    // 주변 8방향 폭탄 개수 반환
    public static int getNearBombNum(int r, int c) {
        int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int count = 0;
        for(int d=0;d<8;d++) {
            int newR = r+dir[d][0];
            int newC = c+dir[d][1];
             
            if(0<=newR && newR<N && 0<=newC && newC<N) {
                if(board[newR][newC] == '*') {
                    count++;
                }
            }
        }
         
        return count;
    }
 
}

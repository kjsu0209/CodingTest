import java.util.*;
import java.io.*;
public class Solution {
 
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(in.readLine());
        int[][] dir = {{-1, 0}, {1, 0}, {0,-1}, {0, 1}}; // U D L R
         
        for(int tc=1;tc<=T;tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            
            // 보드 초기화
            char[][] board = new char[H][W];
            for(int i=0;i<H;i++) {
                String input = in.readLine();
                for(int j=0;j<W;j++) {
                    board[i][j] = input.charAt(j);
                }
            }
             
            int N = Integer.parseInt(in.readLine());
            String command = in.readLine();
             
            int head = 0;
            int[] pos = new int[2];
            char[] car = {'^', 'v', '<', '>'};
            //초기 장소 잡기
            loop: for(int i=0;i<H;i++) {
                for(int j=0;j<W;j++) {
                    for(int k=0;k<4;k++) {
                        if(board[i][j] == car[k]) {
                            head = k;
                            pos[0] = i;
                            pos[1] = j;
                            break loop;
                        }
                    }
                }
            }
            for(int move=0;move<N;move++) {
                char action = command.charAt(move);
                 
                if(action == 'U') {
                    int newR = pos[0] + dir[0][0];
                    int newC = pos[1] + dir[0][1];
                    
                    // 방향 전환
                    head = 0;
                    board[pos[0]][pos[1]] = car[head];
                    if(0<=newR&&newR<H&&0<=newC&&newC<W) {
                         
                        if(board[newR][newC] == '.') {
                            // 이동 가능할 경우 이동
                            board[pos[0]][pos[1]] = '.';
                            board[newR][newC] = car[head];
                            pos[0] = newR;
                            pos[1] = newC;
                             
                        }
                    }
                }
                else if(action == 'D') {
                    int newR = pos[0] + dir[1][0];
                    int newC = pos[1] + dir[1][1];
                    // 방향 전환
                    head = 1;
                    board[pos[0]][pos[1]] = car[head];
                    if(0<=newR&&newR<H&&0<=newC&&newC<W) {
                         
                        if(board[newR][newC] == '.') {
                            // 이동 가능할 경우 이동
                            board[pos[0]][pos[1]] = '.';
                            board[newR][newC] = car[head];
                            pos[0] = newR;
                            pos[1] = newC;
                             
                        }
                    }
                }
                else if(action == 'L') {
                    int newR = pos[0] + dir[2][0];
                    int newC = pos[1] + dir[2][1];
                    // 방향 전환
                    head = 2;
                        board[pos[0]][pos[1]] = car[head];
                    if(0<=newR&&newR<H&&0<=newC&&newC<W) {
                         
                        if(board[newR][newC] == '.') {
                            // 이동 가능할 경우 이동
                            board[pos[0]][pos[1]] = '.';
                            board[newR][newC] = car[head];
                            pos[0] = newR;
                            pos[1] = newC;
                             
                        }
                    }
                }
                else if(action == 'R') {
                    int newR = pos[0] + dir[3][0];
                    int newC = pos[1] + dir[3][1];
                    // 방향 전환
                    head = 3;
                        board[pos[0]][pos[1]] = car[head];
                    if(0<=newR&&newR<H&&0<=newC&&newC<W) {
                         
                        if(board[newR][newC] == '.') {
                            // 이동 가능할 경우 이동
                            board[pos[0]][pos[1]] = '.';
                            board[newR][newC] = car[head];
                            pos[0] = newR;
                            pos[1] = newC;
                             
                        }
                    }
                }
                else if(action == 'S') {
                // 쏘기
                    int[] bullet = {pos[0], pos[1]};
                    while(true) {
                        int newR = bullet[0]+dir[head][0];
                        int newC = bullet[1]+dir[head][1];
                         
                        if(0<=newR&&newR<H&&0<=newC&&newC<W) {
                            // 벽에 부딪힐 경우
                            if(board[newR][newC] =='*') {
                                board[newR][newC] = '.';
                                break;
                            }
                            if(board[newR][newC] == '#') {
                                break;
                            }
                             
                            bullet[0] = newR;
                            bullet[1] = newC;
                        }else {
                            break;
                        }
                    }
                }
                /*
                System.out.println(action);
                for(int i=0;i<H;i++) {
                    for(int j=0;j<W;j++) {
                        System.out.print(board[i][j]);
                    }
                    System.out.println();
                }*/
            }
             
            //출력
            System.out.print("#"+tc+" ");
            for(int i=0;i<H;i++) {
                for(int j=0;j<W;j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }
    }
 
}

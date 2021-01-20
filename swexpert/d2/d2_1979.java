// 0:32

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int count = 0;
			int N = sc.nextInt();
            int K = sc.nextInt();
            
            int [][] board = new int[N][N];
            for(int i=0;i<N;i++){
            	for(int j=0;j<N;j++){
                	board[i][j] = sc.nextInt();
                }
            }
                    
           // 가로로 구멍 있는지 검사
           for(int i=0;i<N;i++){
           	for(int j=0;j<=N-K;j++){
                 boolean canWrite = true;
           		// 해당 칸이 다 비어 있는지
                for(int k=0;k<K;k++){
                	if(board[i][j+k] != 1){
                    	canWrite = false;
                    }
                }
                // 양 옆이 막혀 있는지
                // 왼쪽 확인
                if(j != 0){
                	if(board[i][j-1] != 0){
                    	canWrite = false;
                    }
                }
                //오른쪽 확인
                if(j+K-1 != N-1){
                	if(board[i][j+K] != 0){
                    	canWrite = false;
                    }
                }
                
                if(canWrite)
                    count ++;
            }
           }
			// 세로 확인
            for(int i=0;i<N;i++){
           	for(int j=0;j<=N-K;j++){
                 boolean canWrite = true;
           		// 해당 칸이 다 비어 있는지
                for(int k=0;k<K;k++){
                	if(board[j+k][i] != 1){
                    	canWrite = false;
                    }
                }
                // 양 옆이 막혀 있는지
                // 위쪽 확인
                if(j != 0){
                	if(board[j-1][i] != 0){
                    	canWrite = false;
                    }
                }
                //아래 확인
                if(j+K-1 != N-1){
                	if(board[j+K][i] != 0){
                    	canWrite = false;
                    }
                }
                
                if(canWrite)
                    count ++;
            }
           }
            
            System.out.println("#"+test_case+" " + count);
		}
	}
}

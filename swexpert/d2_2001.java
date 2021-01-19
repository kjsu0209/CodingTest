// 0:08
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
			// input
			int N = sc.nextInt(); // 방 크기
            int M = sc.nextInt(); // 파리채
            
            int[][]board = new int[N][N];
            
            for(int i=0;i<N;i++){
            	for(int j=0;j<N;j++){
                	board[i][j] = sc.nextInt();
                }
            }
            
            // solution
            int maxNum = 0;
            int sum = 0;
			for(int i = 0;i<=N-M;i++){
            	for(int j=0;j<=N-M;j++){
                    sum = 0;
                    for(int k=i;k<i+M;k++){
                    	for(int l=j;l<j+M;l++){
                        	sum += board[k][l];
                        }
                    }
                    maxNum = Math.max(maxNum, sum);
                }
            }
            System.out.println("#"+test_case+" " + maxNum);
		}
	}
}

// 0:20
// 달팽이 숫자
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
		
			int N = sc.nextInt();
            int row = 0;
            int col = 0;
            int limit = N;
            int dir = 0; // 좌 하 우 상
            int counter = 0;
            
            int [][] snail = new int[N][N];
            while(counter < N*N){
            	if(dir == 0){
                	for(int i=col;i<limit;i++){
                    	snail[row][i] = ++counter;
                    }
                    dir = 1;
                    row++;
                }
                else if(dir == 1){
                	for(int i=row;i<limit;i++){
                    	snail[i][limit-1] = ++counter;
                    }
                    dir = 2;
                    limit--;
                }
                else if(dir == 2){
                	for(int i=limit-1;i>=col;i--){
                    	snail[limit][i] = ++counter;
                    }
                    dir = 3;
                }
                else if(dir == 3){
                	for(int i=limit-1;i>=row;i--){
                    	snail[i][col] = ++counter;
                    }
                    dir = 0;
                    col++;
                    
                
                }
            }
            
            System.out.println("#" + test_case);
            for(int i=0;i<N;i++){
            	for(int j=0;j<N;j++){
                	System.out.print(snail[i][j] + " ");
                }
                System.out.println();
            }
			
		}
	}
}

// 0:08
// 파스칼의 삼각형 

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
			int N=sc.nextInt();
            
            int [][]pascal = new int[N][N];
            pascal[0][0] = 1;
            for(int i=1;i<N;i++){
            	for(int j=0;j<=i;j++){
                	if(j == 0 || j == i){
                    	pascal[i][j] = pascal[i-1][0];
                    }
                    else{
                    	pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
                    }
                }
            }
            System.out.println("#"+test_case);
            for(int i=0;i<N;i++){
            	for(int j=0;j<=i;j++){
                	System.out.print(pascal[i][j] + " ");
                }
                System.out.println();
            }
		}
	}
}

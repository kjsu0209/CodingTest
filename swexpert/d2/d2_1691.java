// 0:12
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
            int [][] arr = new int[N][N];
            
            // 입력 받기
            for(int i=0;i<N;i++){
            	for(int j=0;j<N;j++){
                	arr[i][j] = sc.nextInt();
                }
            }
            
            int [][] arr2 = new int[N][N];
            int [][] arr3 = new int[N][N];
			int [][] arr4 = new int[N][N];

           	System.out.println("#"+test_case);

            //돌리기 3번
            //돌리고
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    arr2[j][N-i-1] = arr[i][j];
                }
            }
            //돌리고2
            arr3 = new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    arr3[j][N-i-1] = arr2[i][j];
                }
            }
            //돌리고3
            arr4 = new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    arr4[j][N-i-1] = arr3[i][j];
                }
            }
            //출력
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    System.out.print(arr2[i][j]);
                }
                System.out.print(" ");
                for(int j=0;j<N;j++){
                    System.out.print(arr3[i][j]);
                }
                System.out.print(" ");
                for(int j=0;j<N;j++){
                    System.out.print(arr4[i][j]);
                }
                System.out.println();
            }
            

		}
	}
}

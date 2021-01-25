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
			int N = sc.nextInt();
            int M = sc.nextInt();
            
            int []A = new int[N];
            int []B = new int[M];
            
            for(int i=0;i<N;i++){
            	A[i] = sc.nextInt();
            }
            for(int i=0;i<M;i++){
            	B[i] = sc.nextInt();
            }
            
            int maxSum = 0;
            if(N > M){
            	// 짧은 쪽 - B 움직이기
                // i : 출발 인덱스
                for(int i=0;i<=N-M;i++){
                    int tempSum = 0;
                	for(int j=0;j<M;j++){
                    	tempSum += A[i+j] * B[j];
                    }
                    maxSum = Math.max(maxSum, tempSum);
                }
                
            }else{
                //짧은 쪽 - A 움직이기
             // i : 출발 인덱스
                for(int i=0;i<=M-N;i++){
                    int tempSum = 0;
                	for(int j=0;j<N;j++){
                    	tempSum += B[i+j] * A[j];
                    }
                    maxSum = Math.max(maxSum, tempSum);
                }
            }
            System.out.println("#" + test_case + " " + maxSum);

		}
            
	}
}

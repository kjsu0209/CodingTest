// 0:05
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
            int [] count = new int[5];
            int [] arr= new int[] {2, 3, 5,  7, 11};
            while(N > 1){
                for(int i=0;i<5;i++){
                    if(N%arr[i] == 0){
                        N /=arr[i];
                        count[i]++;
                    }
                }
            }
			System.out.print("#"+test_case);
            for(int i: count){
            	System.out.print(" " + i);
            }
            System.out.println();
		}	
	}
}

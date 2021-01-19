// 0:04
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
		
			int maxNum = Integer.MIN_VALUE;
            int minNum = Integer.MAX_VALUE;
            
            int sum = 0;
            int inputNum = 0;
            for(int i=0;i<10;i++){
            	inputNum = sc.nextInt();
                sum += inputNum;
                maxNum = Math.max(inputNum, maxNum);
                minNum = Math.min(inputNum, minNum);
            }
			
            System.out.println("#"+test_case+" "+ (Math.round((double)(sum- maxNum - minNum)/8) ));
		}
	}
}

// 0:01
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		int sum = 0;
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int num = sc.nextInt();
            if(num%2 != 0)
                sum += num;
            else
                sum -= num;
            
            System.out.println("#"+test_case+" " + sum);
			
		}
	}
}

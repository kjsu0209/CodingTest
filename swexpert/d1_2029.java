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


		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            
            System.out.println("#"+test_case+" " + n1/n2 + " " + n1%n2);

		}
	}
}

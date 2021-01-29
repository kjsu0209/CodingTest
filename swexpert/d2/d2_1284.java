
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
		
			long P = sc.nextInt();
            long Q = sc.nextInt();
            long R = sc.nextInt();
            long S = sc.nextInt();
            long W = sc.nextInt();
            
            long A = P * W;
            
	        long B = Q;
            if(W > R)
                B += (S * (W - R));

            long bill = A > B ? B: A;
            System.out.println("#"+test_case+" " + bill);
		}
	}
}

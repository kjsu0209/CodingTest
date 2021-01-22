
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static final int [] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            System.out.println("#"+test_case);
            for(int i=0;i<8;i++){
            	if(N >= money[i]){
                	System.out.print((N/money[i]) + " ");
                    N = N%money[i];
                }else{
                	System.out.print(0 + " ");
                }
            }
            System.out.println();
		}
	}
}

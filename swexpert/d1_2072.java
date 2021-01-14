// 0:08
// 입출력할 때, nextInt하면 개행문자 안넣어도 자동으로 정수만 가져와준다.
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileInputStream;


public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int sum = 0;
			int num;
			for(int i=0;i<10;i++) {
				num = sc.nextInt();
				if(num%2 == 1) {
					sum += num;
				}
			}
			
			System.out.println("#"+test_case+" "+sum);
		}
	}
}

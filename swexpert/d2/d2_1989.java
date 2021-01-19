// 0:10
// 팰린드롬 검사 : 방법 1 - 문자열당 O(N/2) 시간 복잡도
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
            boolean isTrue = true;
			String s = sc.next();
			for(int i=0;i<s.length()/2;i++){
            	if(s.charAt(i) != s.charAt(s.length()-i-1)){
                    isTrue = false;
                	break;
                }
            }
            if(isTrue)
	            System.out.println("#"+test_case+" 1");
            else
                System.out.println("#"+test_case+" 0");

		}
	}
}

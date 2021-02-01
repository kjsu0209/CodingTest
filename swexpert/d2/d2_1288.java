// 0:07
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
			int [] check = new int[10];
			int checkNum = 0;
            int count = 1;
            
            while(checkNum < 10){
            	String s = "" + (count * N);
                for(int i=0;i<s.length();i++){
                	if(check[Integer.parseInt("" +s.charAt(i))] == 0){
                    	check[Integer.parseInt("" + s.charAt(i))] = 1;
                        //System.out.println(s.charAt(i) + " appears at " + s);
                        checkNum ++;
                    }
                }
                if(checkNum == 10){
                            System.out.println("#"+test_case + " " + s);
                }
                count ++;
            }
            

		}
	}
}

// 0:07
// StringBuilder 사용
import java.util.*;
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
            StringBuilder sb = new StringBuilder("");
            int count = 0;
            for(int i=0;i<N;i++){
            	char c = sc.next().charAt(0);
                int n = sc.nextInt();
                
                for(int j=0;j<n;j++){
                	sb.append(c);
                    count++;
                       if(count == 10){
                	sb.append("\n");
                    count = 0;
                }
                }
             
            }
            System.out.println("#"+test_case + " ");
            System.out.println(sb);
		}
	}
}

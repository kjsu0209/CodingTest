// 0:21

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
		
			String input = sc.next();
            int i, k, j;
            for(i=2; i<Math.min(11, input.length());i++){ // 마디
                String pattern = input.substring(0, i);
                boolean isPattern = true;

                for(j=i;j<input.length();j*=i){
                	if(!pattern.equals(input.substring(j, j+i))){
                        isPattern = false;
                        break;
                    }
                }
                if(isPattern){
                	System.out.println("#" + test_case + " " + i);
                    break;
                }
            }
			
		}
	}
}

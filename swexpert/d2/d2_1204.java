
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
		
            int TC = sc.nextInt();
			int [] score = new int[101];
            
            for(int i=0;i<1000;i++){
            	score[sc.nextInt()] ++;
            }
            
            int maxIndex = 0;
            int maxCount = 0;
            for(int i=0;i<=100;i++){
            	if(score[maxIndex] <= score[i]){
                	maxIndex = i;
                    maxCount = score[i];
                }
            }
            
            System.out.println("#"+TC+" " + maxIndex);

		}
	}
}

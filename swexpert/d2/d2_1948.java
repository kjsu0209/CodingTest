// 0:06
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

        int [] monthEndDay = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int month1=sc.nextInt();
            int day1 = sc.nextInt();
            int month2 = sc.nextInt();
            int day2 = sc.nextInt();
            
            int dist = 0;
            while(month1!=month2 || day1!=day2){
            	if(month1 < month2){
                	day1++;
                    dist++;
                    if(day1 > monthEndDay[month1-1]){
                    	day1 = 1;
                        month1++;
                        if(month1 > 12){
                        	month1 = 1;
                        }
                    }
                    
                }else{
                	day1++;
                    dist++;
                }
            }
            System.out.println("#"+test_case + " " + (dist+1));
		}
	}
}

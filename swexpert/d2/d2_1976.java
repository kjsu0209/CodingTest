
import java.util.Scanner;
import java.io.FileInputStream;
import java.time.LocalTime;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			LocalTime ld = LocalTime.of(sc.nextInt(), sc.nextInt(), 0, 0);

            ld = ld.plusHours(sc.nextInt());
            ld = ld.plusMinutes(sc.nextInt());
            
            if(ld.getHour() % 12 == 0){
                   System.out.println("#"+test_case+" 12 " + (ld.getMinute()));
            }else{
            	   System.out.println("#"+test_case+" " + (ld.getHour()%12) + " " + (ld.getMinute()));
            }
            
		}
	}
}

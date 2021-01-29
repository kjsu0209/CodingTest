
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
            int currentSpeed = 0;
            int distance = 0;
            for(int i=0;i<N;i++){
            	int command = sc.nextInt();
                switch(command){
                    case 0: // 유지
                        break;
                    case 1: // 가속
                        currentSpeed += sc.nextInt();
                        break;
                    case 2: // 감속
                        currentSpeed -= sc.nextInt();
                        if(currentSpeed < 0) currentSpeed = 0;
                        break;
                }
                distance += currentSpeed;
            }
			System.out.println("#"+test_case+" " + distance);
		}
	}
}

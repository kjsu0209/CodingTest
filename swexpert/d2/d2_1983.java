// 0:20

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
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
            int K = sc.nextInt();
			double [][] results = new double[N][2];
            int mid, fin, hw;
            for(int i=0;i<N;i++){
            	mid = sc.nextInt();
                fin = sc.nextInt();
                hw = sc.nextInt();
                results[i][0] = i+1;
                results[i][1] = (0.35 * (double)mid) + (0.45 * (double)fin) + (0.2 * (double)hw);
            }
            Arrays.sort(results, new Comparator<double[]>(){
            	@Override
                public int compare(final double[] entry1,
                                   final double[] entry2){
                	if(entry1[1] < entry2[1])
                        return 1;
                    else
                        return -1;
                }
            });
            
            String []scoreBoard = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
            int eachScore = N/10;
            int nowScore = 0;
            int countScore = 0;
            for(int i=0;i<N;i++){
                //System.out.println(results[i][0]+ " " +results[i][1]);
                countScore ++;
               
            	if(results[i][0] == (double)K){
                	System.out.println("#"+test_case+" " + scoreBoard[nowScore]);
                }
                
                 if(countScore == eachScore){
                	countScore = 0;
                    nowScore ++;
                }
                
            }
		}
	}
}

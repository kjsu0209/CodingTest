// 0:04
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
        int B = sc.nextInt();
        
        int [][] score = {{1, 2, 0}, {1, 3, 1}, {2, 1, 1}, {2, 3, 0}, {3, 1, 0}, {3, 2, 1}};
        
        for(int [] s : score){
        	if(A==s[0] && B==s[1]){
            	if(s[2] == 0)
                    System.out.println("B");
                else
                    System.out.println("A");
            }
        }
	}
}

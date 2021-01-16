// 0:02
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
        int value = 1;
        for(int i=0;i<=num;i++){
        	System.out.print(value);
            value*=2;
            if(i != num){
            	System.out.print(" ");
            }
        }
	}
}

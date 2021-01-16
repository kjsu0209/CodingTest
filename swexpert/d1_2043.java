// 0:01
// 

import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		    int numFind = sc.nextInt();
        int numStart = sc.nextInt();
        
        System.out.println(numFind-numStart +1);
	}
}

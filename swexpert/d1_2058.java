// 0:02
// String.charAt(index) : 문자열에서 해당 인덱스의 char만 가져오기

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String s = "" + N;
        int sum = 0;
        for(int i=0;i<s.length();i++){
        	sum += Integer.parseInt("" + s.charAt(i));
        }
        System.out.println(sum);
	}
}

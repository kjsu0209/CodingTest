// 0:01
// String.toUpperCase() : 대문자로 변환
// String.toLowerCase() : 소문자로 변환
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        String s = sc.next();
		System.out.println(s.toUpperCase());
	}
}

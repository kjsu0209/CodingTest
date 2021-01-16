// N까지 더하기

// 공식 쓰기 : 시간복잡도 O(1)
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
        
        System.out.println((num*(num+1))/2);
	}
}


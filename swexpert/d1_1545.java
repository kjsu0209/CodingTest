import java.util.Scanner;
import java.io.FileInputStream;


class Solution_d1_1545_거꾸로출력해보아요_구미4반_김정수
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int n;

		n = sc.nextInt();
		
		for(int i=n;i>=0;i--){
			System.out.print(i);
			if(i==0) continue;
			System.out.print(" ");
		}
		
		sc.close();
	}
}

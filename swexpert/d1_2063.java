// 0:04
// 중간값: 홀수일 때 N/2, 짝수일 때 N/2 -1

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
                arr[i] = sc.nextInt();
        }
		Arrays.sort(arr);
        if(N%2 == 1)
	        System.out.println(arr[N/2]);
		else
            System.out.println(arr[N/2 -1]);
	}
}

package CodingTest.swexpert.d3;
import java.util.*;
import java.io.*;
public class d4_1244 {
	static int[] arr;
	static int[] maxNum;
	static void recurSwaping(int N, int count) {
		System.out.println(Arrays.toString(arr) + "/" + Arrays.toString(maxNum));
		//System.out.println(N+" "+ count);
		if(N == count) {
			int result = 0;
			for(int i=arr.length-1;i>=0;i--) {
				if(arr[i] > maxNum[i]) {
					result = 1;
					break;
				}
				else if(arr[i] < maxNum[i]) {
					return;
				}
			}
			//System.out.println(result+" "+maxNum);
			if(result == 1) {
				System.out.println("update");
				maxNum = new int[arr.length];
				for(int i=0;i<arr.length;i++) {
					maxNum[i] = arr[i];
				}
			}
			return;
		}
		
		for(int i=0;i<arr.length;i++) {
			if(maxNum[i] < arr[i]) continue;
			for(int j=i+1;j<arr.length;j++) {
				// 교환
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				// 재귀 호출
				recurSwaping(N, count+1);
				//원래대로
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			
		}
	}
	
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			String input1 = in.readLine();
			StringTokenizer st = new StringTokenizer(input1, " ");
			String input = st.nextToken();
			
			arr = new int[input.length()];
			for(int i=0;i<input.length();i++) {
				arr[i] = Integer.parseInt(""+input.charAt(i));
			}
			int N = Integer.parseInt(st.nextToken());
			maxNum = Arrays.copyOf(arr, arr.length);
			recurSwaping(N, 0);
			
			System.out.print("#"+tc+" ");
			for(int item: maxNum) {
				System.out.print(item);
			}
			System.out.println();
		}
	}

}

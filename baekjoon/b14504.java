package baekjoon;

import java.util.Scanner;

public class b14504 {
	public int max = -1000000000;
	public int min = 1000000000;
	
	public void b14504(int n, int[]numbers, int[]op) {
		dfs(numbers, op, 1, numbers[0]);
		
	}
	
	public void dfs(int[] numbers, int[]op, int index, int num) {
		if(index >= numbers.length) {
			this.min = Math.min(this.min, num);
			this.max = Math.max(this.max, num);
			return;
		}
		
		int result = 0;
		
		if(op[0] > 0) {
			op[0]--;
			result = num + numbers[index];
			dfs(numbers, op, index+1, result);
			op[0]++;
		}
		if(op[1] > 0) {
			op[1]--;
			result = num - numbers[index];
			dfs(numbers, op, index+1, result);
			op[1]++;
		}
		if(op[2] > 0) {
			op[2]--;
			result = num * numbers[index];
			dfs(numbers, op, index+1, result);
			op[2]++;
		}
		if(op[3] > 0) {
			op[3]--;
			result = num / numbers[index];
			dfs(numbers, op, index+1, result);
			op[3]++;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, m, r, c, d;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		int [] arr = new int[n];
		int [] arr2 = new int[4];
		for(int i=0;i<n;i++) {
			arr[i] = s.nextInt();
		}
		for(int i=0;i<4;i++) {
			arr2[i] = s.nextInt();
		}
		b14504 b = new b14504();
		b.b14504(n, arr, arr2);
		System.out.println(b.max);
		System.out.println(b.min);
	}

}

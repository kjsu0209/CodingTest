package CodingTest.swexpert.d3;
import java.util.*;
import java.io.*;
public class d3_6808 {
	static int []input; // 규영이
	static int []numbers; // 인영이
	static int N = 9;
	static int winCount;
	static int loseCount;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			input = new int[9];
			numbers = new int[9];
			for(int i=0;i<9;i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			int flag = 0x0;
			for(int i=0;i<9;i++) {
				flag |= 1<<input[i];
			}
			
			winCount = 0;
			loseCount = 0;
			//permutation(0, flag);
			
			// np
			int index = 0;
			for(int i=1; i<=18;i++) {
				boolean isInput = false;
				for(int j=0;j<9;j++) {
					if(input[j] == i) {
						isInput = true;
					}
				}
				if(!isInput) numbers[index++] = i;
			}
			do {
				//System.out.println(Arrays.toString(numbers));
				checkWinner();
			}while(np());
			
			System.out.println("#"+tc+" " + winCount+" "+loseCount);
		}
	}
	
	static boolean np() {
		int i = N-1;
		while(i>0 && numbers[i-1] >= numbers[i]) --i;
		if(i == 0) return false;
		
		int j = N-1;
		while(numbers[i-1] >= numbers[j]) --j;
		swap(i-1, j);
		int k = N-1;
		while(k > i) swap(i++, k--);
		
		return true;
	}
	
	static void permutation(int cnt, int flag) {
		
		if(cnt == 9) {
			// 승패 체크
			checkWinner();
			return;
		}
		
		for(int i=1;i<=18;i++) {
			if((flag & 1<<i) != 0) continue;
			numbers[cnt] = i;
			permutation(cnt+1, flag | 1<<i);
		}
	}
	
	static void checkWinner() {
		int scoreI = 0; // 인영이
		int scoreG = 0; // 규영이
		for(int round=0;round<9;round++) {
			if(input[round] < numbers[round]) {
				// 인영이 승
				scoreI += input[round] + numbers[round];
			}
			else if(input[round] > numbers[round]) {
				// 규영이 승
				scoreG += input[round] + numbers[round];
			}
		}
		
		if(scoreI > scoreG) {
			loseCount++;
		}
		else if(scoreI < scoreG) {
			winCount++;
		}
	}
	
	static void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}

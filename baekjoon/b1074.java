package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b1074 {
	
	static int N, r, c;
	static int count;
	static boolean isFound;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		count = 0;
		visit(0, 0, N);
	}

	static void visit(int row, int col, int n) {
		//System.out.println(row + " "+col+" >>" + n);
		int power = (int)Math.pow(2, n) / 2;

		// 가지치기 : 해당 범위에 찾는 값이 안나오면 카운팅만 하고 스킵
		if(!(row<=r && r<row+power*2 && col<=c && c <col+power*2)) {
			count+=4*(power*power);
			return;
		}
		if(n == 1) {
			for(int i=0;i<2;i++) {
				for(int j=0;j<2;j++) {
					//System.out.println(count+") "+(row+i)+","+(col+j));
					if(row+i == r && col+j == c) {
						System.out.println(count);
					}
					count++;
				}
			}
			return;
		}
		visit(row, col, n-1);
		visit(row, col+power, n-1);
		visit(row+power, col, n-1);
		visit(row+power, col+power, n-1);
	}
}

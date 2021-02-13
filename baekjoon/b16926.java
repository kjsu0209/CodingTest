package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b16926 {
	static int [][] arr;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken()); // 연산의 수
		
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int c=0;c<R;c++) {
			int [][] newArr = new int[N][M];
			// 왼쪽으로 이동 (위 절반)
			int count = 1;
			for(int i=0;i<N/2;i++) {
				for(int j=count;j<M-count+1;j++) {
					newArr[i][j-1] = arr[i][j];
				}
				count++;
			}
			// 아래쪽으로 이동 (왼쪽 절반)
			count = 0;
			for(int i=0;i<M/2;i++) {
				for(int j=count;j <N-count-1;j++) {
					newArr[j+1][i] = arr[j][i];
				}
				count++;
			}
			
			count = 1;
			// 위쪽으로 이동 (오른쪽 절반)
			for(int i=M-1;i>=M/2;i--) {
				for(int j=count;j < N-count+1;j++) {
					newArr[j-1][i] = arr[j][i];
				}
				count++;
			}
			// 오른쪽으로 이동 (아래 절반)
			count = 0;
			for(int i=N-1;i >=N/2;i--) {
				for(int j=count;j<M-1-count;j++) {
					newArr[i][j+1] = arr[i][j];
				}
				count++;
			}
			
			arr = newArr;
			
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

}

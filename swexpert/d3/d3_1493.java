package CodingTest.swexpert.d3;
import java.util.*;
import java.io.*;
public class d3_1493 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = 300;
		int T = Integer.parseInt(in.readLine());
		// 평면 만들기
		int[][] arr = new int[N][N];
		int count = 1;
		int row = N-1;
		int col = 0;
		for(int i=0;i<N;i++) {
			row = N-i-1;
			col = 0;
			for(int j=0;j<=i;j++) {
				arr[row+j][col+j] = count++;
			}
		}
		
		for(int i=N-2;i>=0;i--) {
			row = 0;
			col= N-1-i;
			
			for(int j=0;j<=i;j++) {
				arr[row+j][col+j] = count++;
			}
		}
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			// p 위치 좌표 찾기
			int[] pPos = new int[2];
			loop: for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j] == p) {
						pPos[0] = N-i;
						pPos[1] = j+1;
						break loop;
					}
				}
			}
			
			// q 위치 좌표 찾기
			int[] qPos = new int[2];
			loop: for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j] == q) {
						qPos[0] = N-i-1;
						qPos[1] = j;
						break loop;
					}
				}
			}	
			
			int[] newPos = {pPos[0]+qPos[0], pPos[1]+qPos[1]};
			//System.out.println(Arrays.toString(pPos)+" "+Arrays.toString(qPos));
			System.out.println("#"+tc+" "+arr[N-1-newPos[0]][newPos[1]]);
		}
	}

}

//0:12
// 점화식: 현재 위치까지 오는 경로 최대합 = 현재 위치 값+ max(왼쪽 위까지 오는 경로 최대합, 바로 위까지 오는 경로 최대합)
package CodingTest.algospot;
import java.util.*;
import java.io.*;
public class TRIANGLEPATH {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int C= stoi(in.readLine());
		for(int tc=0;tc<C;tc++) {
			int N = stoi(in.readLine());
			int[][] tri = new int[N][];
			
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				tri[i] = new int[st.countTokens()];
				int index=0;
				while(st.hasMoreTokens()) {
					tri[i][index++] = stoi(st.nextToken());
				}
			}
			//for(int[]a:tri)System.out.println(Arrays.toString(a));
			
			for(int i=1;i<N;i++) {
				// 바로 위 or 왼쪽 위 비교
				tri[i][0] += tri[i-1][0];
				for(int j=1;j<tri[i].length-1;j++) {
					tri[i][j] += Math.max(tri[i-1][j-1], tri[i-1][j]);
				}
				tri[i][tri[i].length-1] += tri[i-1][tri[i-1].length-1];
			}
			
			int maxNum = -1;
			for(int i=0;i<tri[N-1].length;i++) {
				maxNum = Math.max(tri[N-1][i], maxNum);
			}
			
			System.out.println(maxNum);
		}
	}

	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}

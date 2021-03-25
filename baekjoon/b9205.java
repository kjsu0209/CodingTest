// dp로 풀려고 노력했는데 실패한 코드
package CodingTest.baekjoon;
import java.io.*;
import java.util.*;
public class b9205 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(in.readLine());
		for(int tc=1;tc<=t;tc++) {
			int n = Integer.parseInt(in.readLine());
			int[][] arr = new int[n+2][2];
			for(int i=0;i<n+2;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int[][] cArr = new int[n][2];
			for(int i=0;i<n;i++) {
				cArr[i][0] = arr[i+1][0];
				cArr[i][1] = arr[i+1][1];
			}
			Arrays.sort(cArr, (o1, o2)->{
				return Integer.compare(getDist(arr[0], o1), getDist(arr[0], o2));
			});
			for(int i=0;i<n;i++) {
				arr[i+1][0] = cArr[i][0];
				arr[i+1][1] = cArr[i][1];
			}
			
			
			int[] preDist = new int[n+2]; // 행복하게 갈 수 있을 때 이전 지점 위치
			Arrays.fill(preDist, -1);
			preDist[0] = 0;
			
			for(int i=0;i<n+2;i++) {
				for(int j=0;j<i;j++) {
					// 20맥주 이내 거리인지 확인하고 후보군까지 행복하게 도달할 수 있었는지 이전 기록을 보며 확인함.
					if(getDist(arr[i], arr[j]) <= 1000 && preDist[j] >= 0) {
						preDist[i] = getDist(arr[i], arr[j]);
					}
				}
				//System.out.println(Arrays.toString(preDist));
			}
			
			
			if(preDist[n+1] < 0) {
				System.out.println("sad");
			}else {
				System.out.println("happy");
			}
		}
	}
	
	
	static int getDist(int[] a, int[] b) {
		int result = 0;
		if(a[0] < 0 && b[0] >= 0) {
			result = Math.abs(a[0]) + b[0];
		}
		else if(b[0] < 0 && a[0] >= 0) {
			result = Math.abs(b[0]) + a[0];
		}
		else {
			result = Math.abs(Math.abs(a[0]) - Math.abs(b[0]));
		}
		
		if(a[1] < 0 && b[1] >= 0) {
			result += Math.abs(a[1]) + b[1];
		}
		else if(b[1] < 0 && a[1] >= 0) {
			result += Math.abs(b[1]) + a[1];
		}
		else {
			result += Math.abs(Math.abs(a[1]) - Math.abs(b[1]));
		}
		//System.out.println(a[0]+", "+a[1] + "<=>"+b[0]+", "+b[1] +"=" + result);
		return result;
	}

}

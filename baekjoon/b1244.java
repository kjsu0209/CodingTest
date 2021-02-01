// 0:12
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/input_bj_1244.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int [] status = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int index = 0;
		while(st.hasMoreTokens()) {
			status[index++] = Integer.parseInt(st.nextToken());
		}
		int studentNum = Integer.parseInt(in.readLine());
		for(int i=0;i<studentNum;i++) {
			StringTokenizer st2 = new StringTokenizer(in.readLine(), " ");
			index = 0;
			int[] student = new int[2];
			while(st2.hasMoreTokens()) {
				student[index++] = Integer.parseInt(st2.nextToken());
			}
			
			if(student[0] == 1) {
				//남학생
				for(int j=1;j<=N;j++) {
					if(j%student[1] == 0) {
						status[j-1] = status[j-1]==1?0:1;
					}
				}
			}else {
				//여학생
				// 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간 찾기
				int space = 0;
				while(true) {
					if(!(student[1]-space > 0 && student[1]+space<=N)) {
						space --;
						break;
					}
					if(status[student[1]-space-1] == status[student[1]+space-1]) {
						// 대칭일 경우 space 늘리기
						space ++;
					}else {
						space --;
						break;
					}
				}
				for(int j=student[1]-space-1;j<student[1]+space;j++) {
					status[j] = status[j]==1?0:1;
				}
			}
		}
		for(int i=1;i<=N;i++) {
			if(i%20 == 0 && i>19) {
				System.out.println(status[i-1]);
			}else {
				System.out.print(status[i-1] + " ");
			}
		}
	}

}

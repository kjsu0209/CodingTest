package CodingTest.swexpert;
import java.io.*;
import java.util.*;
public class t_5648 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = stoi(in.readLine().trim());
		for(int tc=1;tc<=T;tc++) {
			int N = stoi(in.readLine().trim());
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)-> {
				if(o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			});
			
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				pq.offer(new int[] {stoi(st.nextToken().trim()), stoi(st.nextToken().trim()), stoi(st.nextToken().trim()), stoi(st.nextToken().trim())});
			}
			
			while(true) {
				// 
				
				
				// 영원히 충돌하지 않을 경우 종료
			}
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}

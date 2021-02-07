package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b3078 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int []student = new int[N];
		for(int i=0;i<N;i++) {
			student[i] = in.readLine().length();
		}
		
		int index = 0;
		
		// 현재 윈도우의 이름 글자 당 등장 수
		int []names = new int[21];
		
		long goodFriends = 0;
		
		// 디폴트
		for(int i=0;i<=K;i++) {
			names[student[i]]++;
		}
		
		int start = 0;
		int end = K;
		
		goodFriends += names[student[start]]-1;
		while(start<=end) {
			//System.out.println(start + " " + end);
			// 윈도우 앞으로 땡기기
			names[student[start]]--;
			start ++;
			// 윈도우 뒤로 늘리기
			if(end+1 < N)
				names[student[++end]]++;
			
			// 좋은 친구
			if(start < N)
				goodFriends += names[student[start]]-1; // 자기자신 빼고 더하기
		}
		System.out.println(goodFriends);
	}

}

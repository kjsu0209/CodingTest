package CodingTest.jungol;

import java.io.*;
import java.util.*;

public class jo_2577 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
	
		int[] plates = new int[N];
		for(int i=0;i<N;i++) {
			plates[i] = Integer.parseInt(in.readLine());

		}
		
		int[] selection = new int[d+1];
		// 말단 위치에 쿠폰있으면 지금까지 선택한거 개수+1하기
		int maxCount = 0;
		int count = 0;
		
		int start = 0;
		int end = k-1;
		for(int i=0;i<k;i++) {
			if(selection[plates[i]] == 0) {
				count++;
			}
			selection[plates[i]]++;
		}
		maxCount = count;
		
		
		while(start<N-1) {
			// 앞에꺼 제외시키기
			selection[plates[start]]--;
			if(selection[plates[start]] == 0)
				count--;
			start++;
			
			
			//뒤에꺼 추가하기
			end++;
			if(end == N) {
				end = 0;
			}
			if(selection[plates[end]] == 0) {
				count++;
			}
			selection[plates[end]]++;
			
			
			if(selection[c] == 0) {
				maxCount = Math.max(maxCount, count+1);
			}
			else {
				maxCount = Math.max(maxCount, count);
			}
		}
		
		System.out.println(maxCount);
	}

}

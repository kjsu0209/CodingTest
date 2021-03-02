// solution
package CodingTest.algospot;
import java.util.*;
import java.io.*;
public class FENCE {

	static int N;
	static int [] fences;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int C = stoi(in.readLine());
		
		for(int tc=0;tc<C;tc++) {
			N = stoi(in.readLine());
			fences = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++) fences[i] = stoi(st.nextToken());
			
			System.out.println(fence(0, N-1));
		}
	}
	
	static int fence(int left, int right) {
		if(left == right) {
			return fences[left];
		}
		
		int mid = (left+right)/2;
		
		int result = Math.max(fence(left, mid), fence(mid+1, right));
		int lower  = mid;
		int higher = mid+1;
		int height = Math.min(fences[lower], fences[higher]);
		
		result = Math.max(result, height*2); // 양옆에 구한거랑 지금 위치를 중간으로 끼고 있는 사각형이랑 크기 비교
		
		//지금 위치를 중간으로 끼고 있는 사각형을 넓힌다.
		while(left<lower || higher<right) {
			// 높이가 더 높은 쪽으로 확장
			if(higher<right && (lower == left || fences[lower-1]<fences[higher+1])) {
				higher++;
				height = Math.min(height, fences[higher]);
			}
			else {
				lower--;
				height = Math.min(height, fences[lower]);
			}
			
			result = Math.max(result,  height * (higher-lower+1));
		}
		return result;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}

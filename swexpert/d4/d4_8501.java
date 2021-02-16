package CodingTest.swexpert.d4;
import java.util.*;
import java.io.*;
public class d4_8501 {
	
	static int[] coin;
	static int N;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());

		for(int tc=1;tc<=T;tc++) {
			int count = 0;
			N =  Integer.parseInt(in.readLine());
			coin = new int[N];
			for(int i=1;i<=N;i++) {
				coin[i-1] = i;
			}
			
			do {
				System.out.println(Arrays.toString(coin));

				// 동전 숫자별 앞뒤 확인 배열
				boolean isFlipped[] = new boolean[N+1];
				// 동작 수행
				for(int i=0;i<N;i++) {
					for(int j=i+1;j<N;j++) {
						if(coin[i] < coin[j]) {
							isFlipped[coin[j]] = !isFlipped[coin[j]];
						}
					}
					
				}
				
				// 동작 수행  후 앞면 보이는 동전 카운트
				for(int i=1;i<=N;i++) {
					if(isFlipped[i]) ++count;
					if(count == 1000000007) count = count % 1000000007;
				}
				
				
			}while(np());
			
			System.out.println("#"+tc+" "+count);
		}
		
	}
	
	private static boolean np() {
		int i = N-1;
		// 꼭대기 찾기
		while(i>0 && coin[i-1] >= coin[i]) i--;
		
		if(i == 0) {
			return false;
		}
		
		int j = N-1;
		// 교환할 요소 찾기
		while(coin[i-1] >= coin[j]) j--;
		swap(i-1, j);
		
		int k = N-1;
		// 꼭대기 i 기준으로 뒤부분 오름차순 정렬
		while(i<k) swap(i++, k--);
		
		return true;
	}
	
	static void swap(int i, int j) {
		int temp = coin[i];
		coin[i] = coin[j];
		coin[j] = temp;
		
	}

}

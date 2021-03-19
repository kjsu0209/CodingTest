/*
 * 암호 만들기
 * 조건 1: 서로 다른 알파벳 소문자 L개로 구성
 * 조건 2: 모음 1개 이상, 자음 2개 이상
 * 조건 3: 암호는 알파벳순으로 정렬되어야 함
 * 
 * C개의 문자에서 L개 순서 없이 뽑고 정렬하면 암호 완성 (조합)
 */
package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b1759 {

	static int L; // 암호 길이
	static int C; // 문자 종류 개수
	static char [] pwdChar; // 사용할 수 있는 문자 리스트
	static char[] selected; // dfs에서 선택한 문자 리스트
	public static void main(String[] args) throws Exception{
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		L = Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		pwdChar = new char[C];
		for(int i=0;i<C;i++) pwdChar[i] = st.nextToken().charAt(0);
		
		// 사전순 정렬 --> 정렬 안하면 visited 배열 사용해야 함
		Arrays.sort(pwdChar);
		
		selected = new char[L];
		combi(0, 0, 0, 0);
	}
	
	
	// combi: 현재 선택하는 단어가 몇 번째인지, 지금까지 선택한 모음 개수, 지금까지 선택한 자음 개수
	static void combi(int cnt, int index, int moNum, int jaNum) {
		// 기저조건: cnt가 L에 도달
		if(cnt == L) {
			// 모음 개수와 자음 개수가 조건에 충족되는지 확인
			if(moNum >= 1 && jaNum >= 2) {
				// 충족되면 프린트
				System.out.println(new String(selected));
			}
			return;
		}
		
		// 가지치기 : 앞으로 남은 문자 개수보다 선택해야할 문자 개수가 많으면 탐색 종료
		if((C-index) < (L - cnt))
			return;

		
		// 조합
		for(int i=index;i<C;i++) {			
			selected[cnt] = pwdChar[i];
			
			if(isMoeum(pwdChar[i]))
				combi(cnt+1, i+1, moNum+1, jaNum);
			else
				combi(cnt+1, i+1, moNum, jaNum+1);
		}
	}
	
	// 모음인지 확인하는 메서드
	static boolean isMoeum(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'? true: false;
	}
	
	

}

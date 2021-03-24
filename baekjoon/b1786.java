// KMP

package CodingTest.baekjoon;
import java.io.*;
import java.util.*;
public class b1786 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char[] T = in.readLine().toCharArray();
		char[] P = in.readLine().toCharArray();
		
		// KMP 알고리즘
		
		//1. fail 함수 만들기
		int[] fail = new int[P.length];	//이미 확보되어있는 문자열 길이를 저장한다.
		int suffix = 1; // 접미사 포인터
		int prefix = 0; // 접두사 포인터
		
		for(;suffix<P.length;suffix++) { 
			// 접두사와 접미사를 비교하고 다르면 이전 칸을 접두사로 했을 때 확보한 칸으로 이동해서 검사한다.
			while(prefix > 0 && P[suffix] != P[prefix]) {
				prefix = fail[prefix-1];
			}
			
			// 접두사와 접미사가 일치하면 맨 앞부터 접두사까지의 문자열이 확보되었음을 의미한다.
			if(P[prefix]==P[suffix]) fail[suffix] = ++prefix;
		}
		
		//System.out.println(Arrays.toString(fail));
		
		//2. 탐색
		List<Integer> matchList = new ArrayList<Integer>();
		// i: 텍스트 포인터, j: 패턴 포인터
		// i를 대상으로 패턴을 옮겨보면서 매칭되는지 확인한다.
		for(int i=0, j=0; i<T.length;++i) {
			// i와 j위치의 문자를 비교할 때 다르면 j-1위치에서 확보된 곳이 j로 오게끔 패턴을 이동시킨다.
			while(j>0 && T[i] != P[j]) j = fail[j-1];
			
			if(T[i] == P[j]) {
				if(j == P.length-1) {
					// 패턴 모두 다 일치할 경우
					matchList.add((i+1)-P.length+1); // 시작 인덱스 리스트에 추가
					j = fail[j];
				}else {
					// 다음 패턴 문자 검사
					j++;
				}
			}
		}
		
		System.out.println(matchList.size());
		if(matchList.size() > 0)
			for(int e: matchList)
				System.out.print(e+" ");
		System.out.println();
	}

}

/*
 * 
24 o
39 m
309 m
909 m
9999 m
 */
package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b5904 {

	static int N;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		int sNum = 0;
		int pos = 1;
		char c = 'o';
		
		loop: while(true) {
			//System.out.println(sNum+" "+pos);
			pos = 1;
			// 현재수열 포함한 앞쪽수열체크
			for(int i=0;i<sNum;i++) {
				System.out.print('m');
				for(int j=0;j<i+2;j++) System.out.print('o');
				if(N == pos) {
					c = 'm';
					break loop;
				}
				else if(N<=pos+(i+2)) {
					c = 'o';
					break loop;
				}
				
				pos += 1+(i+2);
			}
			// 뒤쪽수열체크
			for(int i=sNum-2;i>=0;i--) {
				System.out.print('m');
				for(int j=0;j<i+2;j++) System.out.print('o');
				if(N == pos) {
					c = 'm';
					break loop;
				}
				else if(N<=pos+(i+2)) {
					c = 'o';
					break loop;
				}
				
				
				pos += 1+(i+2);
			}
			
			System.out.print('m');
			for(int j=0;j<sNum+2;j++) System.out.print('o');
			if(N == pos) {
				c = 'm';
				break loop;
			}
			else if(N<=pos+(sNum+2)) {
				c = 'o';
				break loop;
			}
			pos += 1+(sNum+2);
			
			// 현재수열 포함한 앞쪽수열체크
			for(int i=0;i<sNum;i++) {
				System.out.print('m');
				for(int j=0;j<i+2;j++) System.out.print('o');
				if(N == pos) {
					c = 'm';
					break loop;
				}
				else if(N<=pos+(i+2)) {
					c = 'o';
					break loop;
				}
				
				pos += 1+(i+2);
			}
			// 뒤쪽수열체크
			for(int i=sNum-2;i>=0;i--) {
				System.out.print('m');
				for(int j=0;j<i+2;j++) System.out.print('o');
				if(N == pos) {
					c = 'm';
					break loop;
				}
				else if(N<=pos+(i+2)) {
					c = 'o';
					break loop;
				}
				
				
				pos += 1+(i+2);
			}
			
			sNum++;
			System.out.println();
		}
		System.out.println();
		System.out.println(c);
		//mooMoo(0, 0);
	}
	


}

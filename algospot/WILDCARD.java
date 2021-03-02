package CodingTest.algospot;
import java.util.*;
import java.io.*;
public class WILDCARD {

	static String W;
	static int N;
	static String[] arr;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int C = stoi(in.readLine());

		for(int tc=0;tc<C;tc++) {
			W = in.readLine();
			N = stoi(in.readLine());
			arr = new String[N];
			for(int i=0;i<N;i++) arr[i] = in.readLine();
			
			PriorityQueue<String> pq = new PriorityQueue<>();
			
			for(int i=0;i<N;i++) {
				if(isMatch(W, arr[i])) {
					pq.offer(arr[i]);
				}
			}
			
			while(!pq.isEmpty()) {
				System.out.println(pq.poll());
			}
			
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static boolean isMatch(String pattern, String s) {
		int index=0;
		//System.out.println(pattern + " " + s);
		while(index<s.length() && index<pattern.length() &&(s.charAt(index) == pattern.charAt(index) || pattern.charAt(index)=='?')) {
			++index;
		}
		
		if(index == pattern.length()) {
			//System.out.println("end of pattern " + pattern.length() + " "+s.length()+" " + (pattern.length() == s.length()));
			return pattern.length() == s.length();
		}
		
		if(pattern.charAt(index) == '*') {
			if(index == pattern.length()-1) return true;
			for(int i=index;i<=s.length();i++) {
				if(isMatch(pattern.substring(index+1), s.substring(i))) {
					return true;
				}
			}
		}
		
		return false;
	}
}

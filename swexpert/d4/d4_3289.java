package CodingTest.swexpert.d4;
import java.io.*;
import java.util.*;
public class d4_3289 {
	
	static int n;
	static int[] parents;
	static int[] cNum;
	
	static void make() {
		for(int i=1;i<=n;i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		if(cNum[aRoot] > cNum[bRoot]) {
			cNum[aRoot] += cNum[bRoot];
			parents[bRoot] = aRoot;
		}
		else {
			cNum[bRoot] += cNum[aRoot];
			parents[aRoot] = bRoot;
		}
		
		return true;
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
		}
	}

}

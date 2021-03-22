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
			StringTokenizer st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			parents = new int[n+1];
			cNum = new int[n+1];
			make();
			System.out.print("#"+tc+" ");
			for(int i=0;i<m;i++) {
				//System.out.println(Arrays.toString(parents));
				st = new StringTokenizer(in.readLine());
				int command = Integer.parseInt(st.nextToken());
				int a =  Integer.parseInt(st.nextToken());
				int b =  Integer.parseInt(st.nextToken());
				
				if(command == 0) {
					union(a, b);
				}
				else if(command == 1) {
					if(find(a) == find(b)) {
						System.out.print('1');
					}
					else {
						System.out.print('0');
					}
				}
				
			}
			System.out.println();
		}
	}

}

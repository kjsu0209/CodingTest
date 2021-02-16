package CodingTest.swexpert.d3;
import java.util.*;
import java.io.*;
public class d3_10726 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			boolean isOff = false;
			int mLen = Integer.toBinaryString(M).length();
			//System.out.println(Integer.toBinaryString(M));
			for(int i=0;i<N;i++) {
				//System.out.println(Integer.toBinaryString((1<<i))+" " + Integer.toBinaryString((M & 1<<i)));
				if((M & 1<<i) == 0) isOff = true;
			}
			if(!isOff) {
				System.out.println("#"+tc+" ON");
			}
			else {
				System.out.println("#"+tc+" OFF");
			}
		}
	}

}

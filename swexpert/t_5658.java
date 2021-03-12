package CodingTest.swexpert;
import java.util.*;
import java.io.*;
public class t_5658 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = stoi(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st= new StringTokenizer(in.readLine());
			int N = stoi(st.nextToken());
			int K = stoi(st.nextToken());
			
			char [] box = in.readLine().toCharArray();
			int num = N/4; // 한 면당 숫자 개수
			PriorityQueue <String> pq = new PriorityQueue<>((o1, o2)->{
				return -(Integer.parseInt(o1, 16)-Integer.parseInt(o2, 16));
			});
			
			for(int start=0;start<box.length;start++) {
				int index = start;
				for(int i=0;i<4;i++) {
					StringBuilder sb = new StringBuilder();
					for(int j=0;j<num;j++) {
						sb.append(box[index++]+"");
						if(index>=box.length) index = 0;
					}
					pq.offer(sb.toString());
				}
			}
			int pre = 0;
			int count = 0;
			while(count<K) {
				if(pre == Integer.parseInt(pq.peek(), 16)) {
					pq.poll();
					continue;
				}
				pre = Integer.parseInt(pq.poll(), 16);
				count++;
			}
			System.out.println("#"+tc+ " "+pre);
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}

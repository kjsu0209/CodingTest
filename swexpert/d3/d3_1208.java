// 0:16
import java.util.*;
import java.io.*;
public class Solution_d3_1208_Flatten_구미_4_김정수 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
			int [] box = new int[100];
			int dump = Integer.parseInt(in.readLine());

			String input = in.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");
			for(int i=0;i<100;i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<dump;i++) {
				int maxIndex =0;
				int maxHeight = box[maxIndex];
				int minIndex=0;
				int minHeight = box[minIndex];
				
				// 최고점 최저점 찾기
				for(int item=0;item<100;item++) {
					if(maxHeight < box[item]) {
						maxHeight = box[item];
						maxIndex = item;
					}
					if(minHeight > box[item]) {
						minHeight = box[item];
						minIndex = item;
					}
				}
				// 평탄화 체크
				if(maxHeight-minHeight <=1) {
					System.out.println("#"+tc+" "+Math.abs(maxHeight-minHeight));
					break;
				}
				
				// 높이 조정하기
				box[maxIndex]--;
				box[minIndex]++;
				
				

				// 마지막 덤프일 경우
				if(i == dump-1) {
					maxIndex =0;
					maxHeight = box[maxIndex];
					minIndex=0;
					minHeight = box[minIndex];
					// 최고점 최저점 찾기 (높이 새로 조정됐을 경우 한번 더 체크하는 용)
					for(int item=0;item<100;item++) {
						if(maxHeight < box[item]) {
							maxHeight = box[item];
							maxIndex = item;
						}
						if(minHeight > box[item]) {
							minHeight = box[item];
							minIndex = item;
						}
					}
					System.out.println("#"+tc+" "+Math.abs(maxHeight-minHeight));
					break;
				}
			}
		}
	}

}

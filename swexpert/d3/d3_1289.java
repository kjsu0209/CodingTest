// 0:10
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        
        for(int test_case=1;test_case<=T;test_case++){
        	String mem = in.readLine();
            char[] arr = new char[mem.length()];
            for(int i=0;i<mem.length();i++){
            	arr[i] = '0';
            }
            int count = 0; //수정 횟수
            for(int i=0;i<mem.length();i++){
                // 문자열과 다르면 전체 바꾸기
                // 같으면 continue
                if(mem.charAt(i) == arr[i]) continue;
                count++;
            	for(int j=i;j<mem.length();j++){
                	arr[j] = mem.charAt(i); // 덮어씌우기
                }
            }
            
            System.out.println("#"+test_case + " " + count);
        }
		
	}
}

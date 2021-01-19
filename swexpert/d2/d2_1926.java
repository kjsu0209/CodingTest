// 0:12
// 3. 6. 9
// 조건: 33, 66, 99도 고려할 것.
// 조건 2: 36, 69도 고려할 것.
// 시간복잡도 O(N*자릿수)

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
        
        for(int i=1;i<=N; i++){

            String s = "" + i;
            boolean hasNum = false;
            for(int j=0;j<s.length();j++){
            	char c = s.charAt(j);
                
                if(c == '3' || c=='6' || c=='9'){
                    System.out.print("-");
                    hasNum = true;
                }
            }
            
            
            if(!hasNum){
                System.out.print(i);
            }
            
            if(i != N){
            	System.out.print(" ");
            }
        }
	}
}

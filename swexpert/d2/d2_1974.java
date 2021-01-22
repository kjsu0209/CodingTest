// 0: 12
import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int [][] board = new int[9][9];
            boolean isValid = true;
            
            for(int i=0;i<9;i++){
            	for(int j=0;j<9;j++){
                 	board[i][j] = sc.nextInt();   
                }
            }
            
            // 블럭 별로 조사
            for(int i=1;i<=3;i++){
                boolean [] check = new boolean[10];
            	for(int j=i*3-3;j<i*3;j++){
                	for(int k=i*3-3;k<i*3;k++){
                        //System.out.print(board[j][k]);
                    	if(check[board[j][k]]){
                        	isValid = false;
                        }else{
                        	check[board[j][k]] = true;
                        }
                    }
                    //System.out.println();
                }
            }
            
            // 라인 별로 조사
            for(int j=0;j<9;j++){
                boolean [] check = new boolean[10];
                boolean [] check2 = new boolean[10];
            	for(int k=0;k<9;k++){
                	if(check[board[j][k]]){
                        isValid = false;
                    }else{
                        check[board[j][k]] = true;
                    }
                    
                    if(check2[board[k][j]]){
                        isValid = false;
                    }else{
                        check2[board[k][j]] = true;
                    }
                }
            }
			
            System.out.println("#"+test_case+" " + (isValid?1:0));
		}
	}
}

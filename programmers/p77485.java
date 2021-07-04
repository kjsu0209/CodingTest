// 행렬 문제
// 0:20
// List<Integer> -> int[] 바꾸는데 스트림 사용함
import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        
        int[][] matrix = new int[rows][columns];
        int cnt = 1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                matrix[i][j] = cnt++;
            }
        }
        
        //회전
        List<Integer> results = new ArrayList();
        for(int i=0;i<queries.length;i++){
            int result = turnBorder(matrix, queries[i]);
            //System.out.println(result);
            results.add(result);
        }
        
        answer = results.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
    
    public int turnBorder(int[][] matrix, int[] query){
        int x1 = query[0]-1;
        int y1 = query[1]-1;
        int x2 = query[2]-1;
        int y2 = query[3]-1;
        
        int minNum = Integer.MAX_VALUE;

        int store = matrix[x1][y1];
        minNum = Math.min(minNum, matrix[x1][y1]);

        
        for(int i=x1;i<x2;i++){
            minNum = Math.min(minNum, matrix[i+1][y1]);
            matrix[i][y1] = matrix[i+1][y1];
        }
        
        for(int i=y1;i<y2;i++){
            minNum = Math.min(minNum, matrix[x2][i+1]);
            matrix[x2][i] = matrix[x2][i+1];
        }
        
        for(int i=x2;i>x1;i--){
            minNum = Math.min(minNum, matrix[i-1][y2]);
            matrix[i][y2] = matrix[i-1][y2];
        }
        
        for(int i=y2;i>y1;i--){            
            minNum = Math.min(minNum, matrix[x1][i-1]);
            matrix[x1][i] = matrix[x1][i-1];
        }
        
        matrix[x1][y1+1] = store;
        
        return minNum;
    }
}

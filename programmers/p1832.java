//미해결
class Solution {
    int MOD = 20170805;
    int count = 0;
    
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int [][]memo = new int[m][n];
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                memo[i][j] = 0;
            }
        }
        dfs(m, n, cityMap, 0, 0, 0, memo);
        return count%MOD;
    }
    public int dfs(int m, int n, int[][] cityMap, int indexR, int indexC, int head, int[][]memo){
        //System.out.println(indexR + "/" + indexC);
        
        //DP
        if(memo[indexR][indexC] != 0){
            if(cityMap[indexR][indexC]==0){
                //System.out.println("Memo hit! " + memo[indexR][indexC]);
                //다른 방향 칸에 2 있고 같은 방향은 1 있을 경우
                if(head == 0){
                    if(indexR < m-1 && indexC < n-1){
                        if(cityMap[indexR+1][indexC] == 2 && cityMap[indexR][indexC+1] == 1){
                            return 0;
                        }
                    }
                    
                }else{
                    if(indexR < m-1 && indexC < n-1){
                        if(cityMap[indexR+1][indexC] == 1 && cityMap[indexR][indexC+1] == 2){
                            return 0;
                        }
                    }
                }
                count += memo[indexR][indexC];
                return memo[indexR][indexC];
                
            }
            else if(cityMap[indexR][indexC] == 2){
                if(head == 0)//위쪽에서 오고 있는 경우
                {
                    if(indexR < m-1){
                        //System.out.println("Memo hit! " + memo[indexR][indexC]);
                        count += memo[indexR][indexC];

                        return memo[indexR][indexC];
                    }         
                }else if(head == 1){
                    if(indexC < n-1){
                        //System.out.println("Memo hit! " + memo[indexR][indexC]);
                        count += memo[indexR][indexC];

                        return memo[indexR][indexC];
                    }   
                }
            }else{
                return 0;
            }
        }
        
        if(indexR == m-1 && indexC == n-1){
            //도착
            memo[indexR][indexC] = 1;
            count ++;
            return 1;
        }
        
        if(cityMap[indexR][indexC] == 0){
        //자유
            if(indexR < m-1){
                if(cityMap[indexR+1][indexC] != 1)
                    memo[indexR][indexC] += dfs(m, n, cityMap, indexR +1, indexC, 0, memo)%MOD;
            }
            if(indexC <n-1)
                if(cityMap[indexR][indexC+1] != 1)
                    memo[indexR][indexC] += dfs(m, n, cityMap, indexR, indexC+1, 1, memo)%MOD;

        }else if(cityMap[indexR][indexC] == 2){
            //회전 금지
            if(head == 0)//위쪽에서 오고 있는 경우
            {
                if(indexR < m-1)
                    if(cityMap[indexR+1][indexC] != 1)
                        memo[indexR][indexC] += dfs(m, n, cityMap, indexR +1, indexC, 0, memo)%MOD;
            }
            else if(head == 1){
                if(indexC < n-1)
                    if(cityMap[indexR][indexC+1] != 1)
                        memo[indexR][indexC] += dfs(m, n, cityMap, indexR, indexC+1, 1, memo)%MOD;
            }

        }else{
            //금지
            return 0;
        }
        return memo[indexR][indexC];
    }
}

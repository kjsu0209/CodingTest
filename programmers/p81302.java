// 0:20
// bfs

import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i=0;i<places.length;i++){
            char[][] p = new char[5][];
            for(int j=0;j<5;j++){
                p[j] = places[i][j].toCharArray();
            }
            answer[i] = hasValidDistance(p);
        }
        
        return answer;
    }
    
    public int hasValidDistance(char[][] place){
        List<int[]> person = new ArrayList<>();
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(place[i][j] == 'P'){
                    person.add(new int[]{i, j});
                }
            }
        }
        for(int[] p: person){
            if(!bfs(p, place)){
                return 0;
            }
        }
        
        return 1;
    }
    
    public boolean bfs(int[] p, char[][]place){
        int[][] dist = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean [][] visit = new boolean[5][5];
        visit[p[0]][p[1]] = true;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.push(new int[]{p[0], p[1], 0});
        
        while(!queue.isEmpty()){
            int[] q = queue.poll();
            
            if(place[q[0]][q[1]] == 'P'){
                if(q[2] <= 2 && q[2]>0){
                    return false;
                }
            }
            else if(place[q[0]][q[1]] == 'X'){
                continue;
            }
            
            for(int[] d: dist){
                int newR = q[0] + d[0];
                int newC = q[1] + d[1];
                
                if(0<=newR && newR<5 && 0<=newC && newC<5){
                    if(!visit[newR][newC]){
                        visit[newR][newC] = true;
                        queue.push(new int[]{newR, newC, q[2]+1});
                    }
                }
            }
            
        }
        
        return true;
    }
}

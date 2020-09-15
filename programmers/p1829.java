# 0:40
import java.util.Queue;
import java.util.LinkedList;
class Pixel{
    public int x;
    public int y;
    public void Pixel(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[][] visit = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                visit[i][j] = 0;
            }
        }
        int eachSizeOfArea = 0;
        Queue <Pixel> queue = new LinkedList<Pixel>();
        boolean ch = false;
        for(int i=0;i<m;i++){
            if(ch) break;
            for(int j=0;j<n;j++){
                if(visit[i][j] == 0 && picture[i][j]!=0){
                    Pixel newp = new Pixel();
                    newp.Pixel(i, j);
                    queue.offer(newp);
                    visit[i][j] = 1;
                    ch = true;
                    break;
                }
            }
        }
        while(queue.size() > 0){
            Pixel p = queue.poll();
            eachSizeOfArea += 1;
            //System.out.println(eachSizeOfArea +","+ p.y);
            if(p.x > 0){
                if(picture[p.x-1][p.y] == picture[p.x][p.y] && visit[p.x-1][p.y] == 0){
                    Pixel newP = new Pixel();
                    newP.Pixel(p.x-1, p.y);
                    queue.offer(newP);
                    visit[p.x-1][p.y] = 1;
                }
            }
            if(p.y > 0){
                if(picture[p.x][p.y-1] == picture[p.x][p.y] && visit[p.x][p.y-1] == 0){
                    Pixel newP = new Pixel();
                    newP.Pixel(p.x, p.y-1);
                    queue.offer(newP);
                    visit[p.x][p.y-1] = 1;
                }
            }
            if(p.x < m-1){
                if(picture[p.x+1][p.y] == picture[p.x][p.y] && visit[p.x+1][p.y] == 0){
                    Pixel newP = new Pixel();
                    newP.Pixel(p.x+1, p.y);
                    queue.offer(newP);            
                    visit[p.x+1][p.y] = 1;
                }
            }
            if(p.y < n-1){
                if(picture[p.x][p.y+1] == picture[p.x][p.y] && visit[p.x][p.y+1] == 0){
                    Pixel newP = new Pixel();
                    newP.Pixel(p.x, p.y+1);
                    queue.offer(newP);
                    visit[p.x][p.y+1] = 1;
                }
            }
            
            if(queue.size() == 0){
                //System.out.println("end of queue");
                numberOfArea += 1;
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, eachSizeOfArea);
                eachSizeOfArea = 0;
                boolean check = false;
                for(int i=0;i<m;i++){
                    if(check) break;
                    for(int j=0;j<n;j++){
                        if(visit[i][j] == 0 && picture[i][j]!=0){
                            Pixel newP = new Pixel();
                            newP.Pixel(i, j);
                            queue.offer(newP);
                            visit[i][j] = 1;
                            check = true;
                            break;
                        }
                    }
                }
            }

        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}

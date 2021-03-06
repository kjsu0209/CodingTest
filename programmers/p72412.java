// 2:30
// 눈물의 순위 검색..
// 모든 경우의 수가 16가지로 작은데도 굳이 트리까지 썼음
// 눈물나는 노가다..
// 마지막 노드에 코딩테스트 점수를 counting sort로 하려고 했는데 최악의 경우 쿼리 하나당 2400000번까지 탐색함
// 점수의 폭이 10만이고, input 점수 다양성이 최대 5만이니까 input 점수를 정렬 후, 이분 탐색이 더 효율적임
// 이분 탐색으로 x값 이상이면서 x값과 가장 가까운 값 찾고, 해당 값의 인덱스를 전체 길이에서 뺀 값이 x이상인 값의 개수이다.
import java.util.*;
class Solution {
    // query를 tree로 담기
    class QueryTree{
        public int level;
        public String query;
        public int childNum; 
        public ArrayList<QueryTree> child;
        public ArrayList<Integer> codingtest; // only for level 4
        
        public QueryTree(int level, String query){
            this.level = level;
            this.query = query;
            this.childNum = 0;
            this.child = new ArrayList<QueryTree>();
            this.codingtest = null;
        }
    }
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};
        // tree 만들기
        QueryTree tree = new QueryTree(0, "");
        makeTree(tree);
        
        // info 채우기
        for(String s: info){
            fillInfo(tree, s.split(" "));
        }
        
        // 
        ArrayList<Integer> queryCount = new ArrayList<>();
        for(String q: query){
            String[] qq = new String[5];
            StringTokenizer st = new StringTokenizer(q);
            int index = 0;
            while(st.hasMoreTokens()){
                String s = st.nextToken();
                if(s.equals("and")) continue;
                qq[index++] = s;
            }
            queryCount.add(exeQuery(tree, qq));
        }
        //System.out.println(queryCount);
        //answer = queryCount.toArray();
        answer = new int[queryCount.size()];
        int index = 0;
        for(int q: queryCount) answer[index++] = q;
        return answer;
    }
    
    public int exeQuery(QueryTree t, String[] q){
        if(t.level == 4){
            if(t.codingtest == null) return 0;

            // x점 이상
            int x = Integer.parseInt(q[t.level]);
            // 이진 트리 순회
            int count = 0;
            int start = 0;
            int end = t.codingtest.size()-1;
            
            
            while(start<=end){
                int mid = (start+end)/2;
                
                if(t.codingtest.get(mid) < x){
                    start = mid+1;
                }
                else{
                    count = t.codingtest.size() - mid;
                    end = mid-1;
                }
            }
            
            return count;
        }
        int result = 0;
        for(QueryTree c: t.child){
            // 조건
            if(q[t.level].equals(c.query)){
                result += exeQuery(c, q);
            }
            else if(q[t.level].equals("-")){
                result += exeQuery(c, q);
            }
        }
        
        return result;
    }
    
    public void fillInfo(QueryTree t, String[] info){
        //t.childNum += 1;
        for(QueryTree c: t.child){
            if(info[t.level].equals(c.query)){
                fillInfo(c, info);
            }
        }
        // codingtest 점수 넣기
        if(t.level == 4){
            if(t.codingtest == null){
                t.codingtest = new ArrayList<>();
            }
            // 값 넣기
            t.codingtest.add(Integer.parseInt(info[t.level]));
            // sorting
            Collections.sort(t.codingtest);
        }
    }

    
    public void makeTree(QueryTree t){
        if(t.level == 0){
            t.child.add(new QueryTree(1, "cpp"));
            t.child.add(new QueryTree(1, "java"));
            t.child.add(new QueryTree(1, "python"));
        }
        else if(t.level == 1){
            t.child.add(new QueryTree(t.level+1, "backend"));
            t.child.add(new QueryTree(t.level+1, "frontend"));
        }
        else if(t.level == 2){
            t.child.add(new QueryTree(t.level+1, "junior"));
            t.child.add(new QueryTree(t.level+1, "senior"));
        }
        else if(t.level == 3){
            t.child.add(new QueryTree(t.level+1, "chicken"));
            t.child.add(new QueryTree(t.level+1, "pizza"));
            return;
        }
        
        for(QueryTree q: t.child){
            makeTree(q);
        }
    }
}

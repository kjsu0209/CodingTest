// 0:24
// 부분합 문제
class GenomicRangeQuery {
    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        // prefix sum

        int [][] hist = new int[S.length()][4]; // 0~i 인덱스 범위에서 impact factor 개수 총합

        // hist 채우기
        int [] current = new int[4];
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);

            if(c == 'A'){
                current[0] ++;
            }
            else if(c == 'C'){
                current[1] ++;
            }
            else if(c == 'G'){
                current[2] ++;
            }
            else if(c == 'T'){
                current[3] ++;
            }

            for(int j=0;j<4;j++)
                hist[i][j] = current[j];
        }

        // query 답 넣기
        int [] answer = new int[P.length];

        for(int i=0;i<P.length;i++){
            // S(n..m) = S(m) - S(n)

            // n이 0일 경우: S(m)
            if(P[i] == 0){
                for(int j=0;j<4;j++){
                    if(hist[Q[i]][j] > 0){
                        answer[i] = j+1;
                        break;
                    }
                }
            }
            // n == m일 경우: S(m) - S(m-1)
            else if(P[i] == Q[i]){
                for(int j=0;j<4;j++){
                    if(hist[Q[i]][j] - hist[Q[i]-1][j] > 0){
                        answer[i] = j+1;
                        break;
                    }
                }
            }
            else{ // 그 외의 경우: S(m) - S(n-1)
                for(int j=0;j<4;j++){
                    if(hist[Q[i]][j] - hist[P[i]-1][j] > 0){
                        answer[i] = j+1;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}

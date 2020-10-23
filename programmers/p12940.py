# gcd, lmd
class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        answer[0] = find_gcd(n, m);
        answer[1] = (n*m) / answer[0];
        return answer;
    }
    
    public int find_gcd(int n, int m){
        return m!=0 ? find_gcd(m, n%m) : n;
    }
}

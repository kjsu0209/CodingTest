# 에라토스테네스의 체
class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] numbers = new int[n+1];
        numbers[0] = 0;
        numbers[1] = 0;
        for(int i=2;i<=n;i++){
            numbers[i] = 1;
        }
        
        for(int i=2;i<=n;i++){
            if(numbers[i] > 0){
                for(int j=2;j*i<=n;j++){
                    numbers[j*i] = 0;
                }
            }
        }
        
        for(int i=0;i<=n;i++){
            answer += numbers[i];
        }
        return answer;
    }
}

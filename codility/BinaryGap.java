class BinaryGap {
    public int solution(int N) {
        int answer = 0;

        int counter = 0;
        boolean startCount = false;
        int num = N;

        while(num >= 1){
            if(num%2 == 1){
                if(startCount){
                    answer = Math.max(answer, counter);
                    counter = 0;
                }
                else{
                    startCount=true;
                    counter = 0;
                }
            }else{
                counter++;
            }
            num/=2;
        }


        return answer;
    }
}

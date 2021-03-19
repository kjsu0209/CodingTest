# 자바에서 자주 쓰이는 코드 모음

### 입력 받기
```
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
```

### 프로그래머스 풀 때 디버깅용 메인 메서드
```
public static void main(String args[]){
  // TC input
  int n = 0;
  int m = 0;
  int k = 0;
  String s = "";
  int[] inputIntArr = {};
  
  Solution s = new Solution();
  s.solution(); // 함수 호출
}
```

### 4방향   
```
static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상, 우, 하, 좌

// row col에서 dir 방향으로 이동한 칸이 범위 안에 속해 있는지 확인하는 메서드
public boolean isValid(int dir, int row, int col, int limitR, int limitC){
  int newR = row + direction[dir][0];
  int newC = col + direction[dir][1];
  
  if(0<=newR&&newR<limitR && 0<=newC&&newC<limitC)
    return true;
  return false;
}

```


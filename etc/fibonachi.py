# 1. 재귀
def fibo_r(n):
  if n < 3:
    return n
  else:
    return fibo_r(n-1) + fibo_r(n-2)

# 2. DP 메모제이션
def fibo_m(n):
  memo = [0 for _ in range(n+1)]
  memo[1] = 1
  memo[2] = 2
  
  for i in range(3, n+1):
    memo[i] = memo[i-1] + memo[i-2]
  
  return memo[n]
  
# 3. DP 공간 2칸 쓰기
def fibo_v(n):
  pre = [1, 2]
  index = 0
  
  while index <= n:
    pre[1] = pre[0] + pre[1]
  
  return pre[1]

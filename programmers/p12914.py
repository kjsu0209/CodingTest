# 0:06
# 점화식: N[i] = N[i-1] + N[i-2]
def solution(n):
    memo = [None for _ in range(2001)]
    memo[1] = 1
    memo[2] = 2
    for i in range(3, n+1):
        memo[i] = (memo[i-1] + memo[i-2]) % 1234567
    
    return memo[n]

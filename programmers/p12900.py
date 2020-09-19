# 0:20
def solution(n):
    answer = 0
    memo = [0 for i in range(60001)]
    for i in range(4):
        memo[i] = i
    
    for i in range(4, n+1):
        memo[i] = (memo[i-1] + memo[i-2])%1000000007
        
    answer = memo[n]
    return answer

# 0:12
from collections import deque
def solution(n):
    ans = 0
    pos = n
    
    while pos > 0:
        if pos % 2 == 1:
            ans += 1
            pos = pos - 1
        else:
            pos = pos // 2

    return ans

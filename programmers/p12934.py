# 0:02
import math
def solution(n):
    answer = 0
    s = str(math.sqrt(n)).split('.')
    if s[1] == '0':
        answer = (int(s[0])+1)**2
    else:
        answer = -1
    
    return answer

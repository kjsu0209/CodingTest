# 0:08
import sys
def solution(A):
    # write your code in Python 3.6
    answer = sys.maxsize
    total = sum(A)
    sum_val = 0
    for i in range(0, len(A)-1):
        sum_val += A[i]
        if sum_val < 0 and (total - (sum_val)*-1) > 0:
            answer = min(answer, abs((total - (sum_val)*-1) - sum_val*-1))
        else:
            answer = min(answer, abs((total - sum_val)-sum_val))

    if len(A) == 2:
        answer = abs(A[0]-A[1])
    return answer

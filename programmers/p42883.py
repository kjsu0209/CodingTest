# 0:48
from itertools import combinations
def solution(number, k):
    num = number
    num_len = len(number) - k
    
    i = 0
    while len(num) != num_len:
        if i>=len(num)-1: break
        num1 = int(num[i])
        num2 = int(num[i+1])
        if num1 < num2:
            num = num[0:i:] + num[i+1::]
            if i>0:
                i -= 1
        elif num1 == num2:
            if int(num[-1]) == num1:
                num = num[0:i:] + num[i+1::]
            else:
                i += 1
        else:
            i += 1
    if len(num) != num_len:
        num = num[:num_len]
    return num

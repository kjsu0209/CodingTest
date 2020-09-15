# 0:16
from math import gcd
def solution(w,h):
    answer = w * h
    g = gcd(w, h)
    num1 = w//g
    num2 = h//g
    d = (num1-1) * (num2-1)
    answer -= (h//num2) * (num1*num2 - d)
    return answer

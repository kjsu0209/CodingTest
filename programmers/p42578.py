# 0:10
import copy
from itertools import combinations
import math

def solution(clothes):
    answer = 1
    closet = {}
    combi_list = []
    
    for c in clothes:
        if c[1] not in closet.keys():
            closet[c[1]] = 1
        else:
            closet[c[1]]+=1
    
    combi_list = closet.values()
    
    for c in combi_list:
        answer *= c+1
    answer -= 1

    return answer

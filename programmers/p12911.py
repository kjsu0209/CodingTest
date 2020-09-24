# 0:08
def solution(n):
    answer = 0
    bin_n = bin(n)[2:]
    c_1 = bin_n.count('1')
    next_n = n+1
    next_c = bin(next_n)[2:].count('1')
    while next_c != c_1:
        next_n += 1
        next_c = bin(next_n)[2:].count('1')
    answer = next_n
    return answer

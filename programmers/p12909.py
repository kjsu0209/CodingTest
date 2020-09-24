# 0:05
def solution(s):
    answer = True
    if s[0] == ')' or s[-1] == '(':
        return False
    c1 = 0
    c2 = 0
    count = 0
    for w in s:
        if count < 0:
            return False
        if w == '(':
            count += 1
            c1 += 1
        else:
            count -= 1
            c2 += 1
    #print(c1,c2)
    if c1 == c2:   
        return True
    else:
        return False

# 3진법
# 0:08
def solution(n):
    answer = 0
    a = make_three(n)
    
    a = list(a)
    for i, w in enumerate(a):
        if int(w) != 0:
            answer += int(w) * (3**i)
    
    return answer

def make_three(n):
    if n < 3:
        return str(n)
    q, r = divmod(n, 3)
    return make_three(q) + str(r)

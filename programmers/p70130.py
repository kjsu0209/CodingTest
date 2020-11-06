# 월간 코드 챌린지 시즌 1 11월
def solution(a):
    answer = 0
    alpha = {}
    for w in a:
        if w in alpha.keys():
            alpha[w] += 1
        else:
            alpha[w] = 1
    rank = sorted(alpha.items(), key=lambda x: x[1], reverse=True)
    
    for r in rank:
        n = is_star(a, r[0], r[1])
        if n > 1:
            return n
    return answer


def is_star(a, n, m):
    total = len(a)
    index = 0
    while index < len(a)-1:
        if n not in a[index:index+2]:
            total -= 1
            index += 1
        else:
            if a[index] != a[index+1]:
                index += 2
            else:
                total -= 1
                index += 1
    
    if total < 2:
        return 0
    elif total % 2 != 0:
        return total - 1
    return total

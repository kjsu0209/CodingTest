# 0:40
def solution(n, t, m, p):
    answer = ''
    number = 0
    index = 0
    count = 0
    cycle = ''
    while count <= t*m:
        # 값 구하기
        if n == 2:
            c = bin(number)[2:]
        elif n == 8:
            c = oct(number)[2:]
        elif n == 16:
            c = hex(number)[2:]
        elif n == 10:
            c = str(number)
        else:
            c = convert(number, n)
        cycle += c
        count+= len(c)
        number+=1
    #print(cycle)
    answer = ''
    for i in range(p-1, len(cycle), m):
        if len(answer) >= t: break
        answer += cycle[i]
    answer = answer.upper()
    return answer

def convert(n, base):
    T = "0123456789ABCDEF"
    q, r = divmod(n, base)
    if q == 0:
        return T[r]
    else:
        return convert(q, base) + T[r]

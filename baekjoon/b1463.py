def solution(x):
    m = [0]*(x+1)
    m[1] = 0
    if x>=2:
        m[2] = 1
    if x>=3:
        m[3] = 1

    for i in range(4, x+1):
        num = x+1
        if i%3 == 0:
            if int(i/3)%3 == 0:
                m[i] = m[int(i/3)]+1
            else:
                m[i] = m[int(i / 3)] + 1
            num = m[int(i/3)]+1
        if i%2 == 0:
            if num > m[int(i/2)]+1:
                m[i] = m[int(i/2)]+1
                num = m[int(i / 2)] + 1

        if m[i] > m[i-1]+1:
            m[i] = m[i-1]+1
        if num == x+1:
            m[i] = m[i-1]+1

    answer = m[x]
    return answer


n = int(input())
print(solution(n))

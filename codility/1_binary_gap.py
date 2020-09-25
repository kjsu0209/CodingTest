def solution(N):
    # write your code in Python 3.6
    answer = 0
    num = N
    start = -1
    mid = -1
    index = 0
    pre = -1
    while num > 1:
        n = num % 2
        num = num // 2
        if n == 1:
            if pre == 0 and mid != -1:
                answer = max(answer, index)
                index = 0
                mid = -1
            pre = 1
        elif n == 0:
            if pre == 1 and mid == -1:
                index = 1
                mid = 1
            elif mid != -1:
                index += 1
            pre = 0
    if num == 1:
        if pre == 0 and mid != -1:
                answer = max(answer, index)
                index = 0
                mid = -1
    return answer

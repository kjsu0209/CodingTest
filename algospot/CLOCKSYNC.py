# RTE 에러
# 논리는 맞는것같은데 런타임 에러 이유를 모르겠음..
# 채점 컴파일러가 파이썬 3.4써서 그런가

import math


def solution(clock, swit):
    if swit == 10:
        if check_o(clock) is True:
            return 0
        else:
            return math.inf

    ret = math.inf
    for i in range(4): # 0~3회까지 스위치 누르는 경우 재귀로 호출하기
        ret = min(ret, i + solution(clock, swit+1))
        # 시계 돌리기
        for s in switch[swit]:
            clock[s] = tick_right(clock[s])

    return ret


def check_o(clock):
    for c in clock:
        if c != 12:
            return False
    return True


def tick_right(hour):
    if hour < 10:
        return hour + 3
    elif hour == 9:
        return 12
    else:
        return hour + 3 - 12


switch = [[0, 1, 2], [3, 7, 9, 11],
        [4, 10, 14, 15], [0, 4, 5, 6, 7],
        [6, 7, 8, 10, 12], [0, 2, 14, 15],
        [3, 14, 15], [4, 5, 7, 14, 15],
        [1, 2, 3, 4, 5], [3, 4, 5, 9, 13]]

tc = int(input())
for t in range(tc):
    try:
        clock = list(map(int, input().split(' ')))
    except:
        print('input data error')
    result = solution(clock, 0)
    if result == math.inf:
        result = -1
    print(result)

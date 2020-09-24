# 게임 개발(118p) : 0:26


def solution(n, m, loc, maps):
    dir = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    count = 0
    while True:
        if maps[loc[0]][loc[1]] == 0:
            maps[loc[0]][loc[1]] = 2
            count += 1
        head = loc[2]
        moved = False
        for i in range(0, 4):
            head = head-1
            if head < 0:
                head = 3
            next_r = loc[0]+dir[head][0]
            next_c = loc[1]+dir[head][1]
            if 0 <= next_r < n and 0 <= next_c < m:
                if maps[next_r][next_c] == 0:
                    loc[0] = next_r
                    loc[1] = next_c
                    loc[2] = head
                    moved = True
                    break
        if moved is False:
            head = loc[2]
            for i in range(2):
                head = head - 1
                if head < 0:
                    head = 3
            next_r = loc[0] + dir[head][0]
            next_c = loc[1] + dir[head][1]
            if maps[next_r][next_c] == 1:
                break
            else:
                loc[0] = next_r
                loc[1] = next_c
    print(count)


init = list(map(int, input().split()))
n = init[0]
m = init[1]

loc = list(map(int, input().split()))

maps = [[] for i in range(n)]
for i in range(n):
    maps[i] = list(map(int, input().split()))

solution(n, m, loc, maps)

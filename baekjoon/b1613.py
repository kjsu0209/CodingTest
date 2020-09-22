# 0: 33 Floyd Washall - pypy3으로 돌려야 시간초과 안됨
init = input().split()
n = int(init[0])
k = int(init[1])
arr = []
for i in range(k):
    arr.append(list(map(int, input().split())))

s = int(input())
quest = []
for i in range(s):
    quest.append(list(map(int, input().split())))

import math
def solution(n, k, s, arr, quest):
    dist = [[math.inf for i in range(n)] for j in range(n)]
    for i in range(n):
        dist[i][i] = 0
    for a in arr:
        dist[a[0]-1][a[1]-1] = 1
    for k in range(n):
        for i in range(n):
            if dist[i][k] == math.inf: continue
            for j in range(n):
                if dist[i][j] > dist[i][k] + dist[k][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]

    #print(dist)
    for q in quest:
        val1 = dist[q[0]-1][q[1]-1]
        val2 = dist[q[1]-1][q[0]-1]
        if val1 == math.inf and val2 == math.inf:
            print(0)
        elif val1 == math.inf and val2 != math.inf:
            print(1)
        else:
            print(-1)


solution(n, k, s, arr, quest)

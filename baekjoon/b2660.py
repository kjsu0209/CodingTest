# 0:25 Floyd Washall
n = int(input())
arr = []
while True:
    s = list(map(int, input().split()))
    if s[0] == -1:
        break
    arr.append(s)


import math
def solution(n, arr):
    dist = [[math.inf for j in range(n)] for i in range(n)]
    for i in range(n):
        dist[i][i] = 0

    for a in arr:
        dist[a[0]-1][a[1]-1] = 1
        dist[a[1]-1][a[0]-1] = 1

    for k in range(n):
        for i in range(n):
            for j in range(n):
                if dist[i][k] + dist[k][j] < dist[i][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]
                    dist[j][i] = dist[i][k] + dist[k][j]

    point = []
    for i, di in enumerate(dist):
        max_val = max(di)
        point.append([i, max_val])
    point = sorted(point, key=lambda x: (x[1], x[0]))
    min_val = point[0][1]
    for i, p in enumerate(point):
        if min_val != p[1]:
            point = point[:i]
            break

    # 출력
    print(min_val, len(point))
    total = []
    for p in point:
        total.append(p[0]+1)
    print(' '.join(list(map(str, total))))


solution(n, arr)

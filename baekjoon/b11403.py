# 0:22 Floyd Washall
n = int(input())
arr = [[] for i in range(n)]

for i in range(n):
    arr[i] = list(map(int, input().split()))

import math
def solution(n, arr):
    dist = [[math.inf for j in range(n)] for i in range(n)]

    for i in range(n):
        for j in range(n):
            if arr[i][j] != 0:
                dist[i][j] = arr[i][j]

    for k in range(n):
        for i in range(n):
            for j in range(n):
                if dist[i][k] + dist[k][j] < dist[i][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]

    for i in range(n):
        for j in range(n):
            if dist[i][j] == math.inf:
                dist[i][j] = 0
            else:
                dist[i][j] = 1

    for i in range(n):
        print(' '.join(list(map(str, dist[i]))))

solution(n, arr)

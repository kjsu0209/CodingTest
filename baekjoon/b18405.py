# 0:25
# bfs, priorityQueue

import heapq
def solution(n, k, arr, s, x, y):
    visit = [[False for i in range(n)] for j in range(n)]
    queue = []
    direction = [[-1, 0], [0, 1], [1, 0], [0, -1]]

    for i in range(n):
        for j in range(n):
            if arr[i][j] != 0:
                heapq.heappush(queue, (0, arr[i][j], i, j))
                visit[i][j] = True

    while len(queue) > 0:
        #print(queue)
        q = heapq.heappop(queue)

        if q[0] == s:
            continue

        for d in direction:
            nextR = q[2] + d[0]
            nextC = q[3] + d[1]
            if 0 <= nextR < n and 0 <= nextC < n:
                if visit[nextR][nextC] is False and arr[nextR][nextC] == 0:
                    heapq.heappush(queue, (q[0]+1, q[1], nextR, nextC))
                    arr[nextR][nextC] = q[1]
                    visit[nextR][nextC] = True

    print(arr[x-1][y-1])


n, k = list(map(int, input().split()))
arr = []

for i in range(n):
    arr.append(list(map(int, input().split())))

s, x, y = list(map(int, input().split()))

solution(n, k, arr, s, x, y)

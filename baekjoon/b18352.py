# 0:22
# bfs, dijkstra

import math
from collections import deque
def solution(n, arr, k, x):
    dist = [math.inf for i in range(n)]
    dist[x-1] = 0

    next_node = [[] for i in range(n)]
    for a in arr:
        next_node[a[0]-1].append(a[1])

    queue = deque([])
    for a in arr:
        if a[0] == x:
            queue.append([a[1], 1])

    while len(queue) > 0:
        q = queue.popleft()

        dist[q[0]-1] = min(dist[q[0]-1], q[1])

        for node in next_node[q[0]-1]:
            if dist[node-1] > q[1] + 1:
                queue.append([node, q[1]+1])

    count = 0
    for i, d in enumerate(dist):
        if d == k:
            print(i + 1)
            count += 1
    if count == 0:
        print(-1)


n, m, k, x = list(map(int, input().split()))
arr = []
for i in range(m):
    arr.append(list(map(int, input().split())))

solution(n, arr, k, x)

# 0:12 pypy3으로 해야 시간초과 안남.
from collections import deque
def solution(n, arr, degree):
    result = [0 for i in range(n+1)]
    queue = deque([])
    for i in range(1, n+1):
        if degree[i] == 0:
            queue.append([i, 1])
    while len(queue) > 0:
        q = queue.popleft()
        result[q[0]] = q[1]
        for a in arr[q[0]]:
            degree[a] -= 1
            if degree[a] == 0:
                queue.append([a, q[1]+1])
    print(' '.join(list(map(str, result[1:]))))

pre = list(map(int, input().split()))
n = pre[0]
m = pre[1]
degree = [0 for i in range(n+1)]
arr = [[] for i in range(n+1)]
for i in range(m):
    data = list(map(int, input().split()))
    arr[data[0]].append(data[1])
    degree[data[1]] += 1

solution(n, arr, degree)

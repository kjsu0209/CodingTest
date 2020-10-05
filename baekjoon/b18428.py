# dfs

from collections import deque
import copy

result = True
def solution(n, arr, obstacle):
    if obstacle == 3:
        return is_danger_student(n, arr)

    a = copy.deepcopy(arr)
    global result
    for i in range(n):
        for j in range(n):
            if a[i][j] == 'X':
                a[i][j] = 'O'
                r = solution(n, a, obstacle+1)
                if r is False:
                    result = False
                a[i][j] = 'X'

    return r


def is_danger_student(n, arr):
    visit = [[False for i in range(n)] for j in range(n)]
    queue = deque([])
    for i in range(n):
        for j in range(n):
            if arr[i][j] == 'T':
                queue.append([i, j])

    for q in queue:
        for i in range(q[0]-1, -1, -1):
            if arr[i][q[1]] == 'S' and visit[i][q[1]] is False:
                return True
            elif arr[i][q[1]] == 'O':
                break

        for i in range(q[1]-1, -1, -1):
            if arr[q[0]][i] == 'S' and visit[q[0]][i] is False:
                return True
            elif arr[q[0]][i] == 'O':
                break

        for i in range(q[0]+1, n):
            if arr[i][q[1]] == 'S' and visit[i][q[1]] is False:
                return True
            elif arr[i][q[1]] == 'O':
                break

        for i in range(q[1]+1, n):
            if arr[q[0]][i] == 'S' and visit[q[0]][i] is False:
                return True
            elif arr[q[0]][i] == 'O':
                break

    return False


n = int(input())
arr = []
for i in range(n):
    arr.append(input().split())


solution(n, arr, 0)
if result is False:
    print('YES')
else:
    print('NO')

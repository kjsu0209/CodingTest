# 0:10
from collections import deque
def solution(n, arr):
    arr = sorted(arr, key=lambda x: (x[1], x[0]))
    arr = deque(arr)
    answer = 0
    end_time = 0
    while len(arr) > 0:
        a = arr.popleft()

        if a[0] >= end_time:
            end_time = a[1]
            answer += 1

    return answer


n = int(input())
arr = []
for i in range(n):
    arr.append(list(map(int, input().split())))

print(solution(n, arr))

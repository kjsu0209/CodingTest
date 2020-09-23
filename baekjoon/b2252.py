# Topological Sort
init = input().split()
n = int(init[0])
m = int(init[1])
arr = [[] for i in range(n)]
degree = [0 for i in range(n)]
for i in range(m):
    l = list(map(int, input().split()))
    arr[l[0]-1].append(l[1]-1)
    degree[l[1]-1]+=1


from collections import deque
def solution(n, degree, arr):
    result = []
    queue = deque([])
    # 시작 노드 초기값으로 넣기
    for i, d in enumerate(degree):
        if d == 0:
            queue.append(i+1)
    while len(queue) > 0:
        q = queue.popleft()
       # print(q, queue, degree, arr[q-1])
        result.append(q)
        for a in arr[q-1]:
            degree[a] -= 1
            if degree[a] == 0:
                queue.append(a+1)

    print(' '.join(list(map(str, result))))

solution(n, degree, arr)

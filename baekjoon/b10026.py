# 0:46
def solution(n, arr):
    n1 = normal(n, arr)
    n2 = abnormal(n, arr)
    print(n1, n2)

def abnormal(n, arr):
    area = 0
    visit = [[0 for j in range(len(arr[0]))] for i in range(len(arr))]
    queue = []
    for a in range(n):
        arr[a] = arr[a].replace("R", "G")
    while True:
        nextI = 0
        nextJ = 0
        checked = False
        for i in range(n):
            if checked: break
            for j in range(n):
                if visit[i][j] == 0:
                    nextI = i
                    nextJ = j
                    checked = True
                    break
        if checked is False:
            break
        queue.append([nextI, nextJ])
        visit[nextI][nextJ] = 1

        while len(queue) > 0:
            q = queue.pop(0)
            color = arr[q[0]][q[1]]

            # 인접 노드 중 색깔 같은게 있는지 검사
            if q[0] > 0:
                if visit[q[0] - 1][q[1]] == 0 and arr[q[0] - 1][q[1]] == color:
                    queue.append([q[0] - 1, q[1]])
                    visit[q[0] - 1][q[1]] = 1
            if q[0] + 1 < n:
                if visit[q[0] + 1][q[1]] == 0 and arr[q[0] + 1][q[1]] == color:
                    queue.append([q[0] + 1, q[1]])
                    visit[q[0] + 1][q[1]] = 1
            if q[1] > 0:
                if visit[q[0]][q[1] - 1] == 0 and arr[q[0]][q[1] - 1] == color:
                    queue.append([q[0], q[1] - 1])
                    visit[q[0]][q[1] - 1] = 1
            if q[1] + 1 < n:
                if visit[q[0]][q[1] + 1] == 0 and arr[q[0]][q[1] + 1] == color:
                    queue.append([q[0], q[1] + 1])
                    visit[q[0]][q[1] + 1] = 1
        area += 1
    return area

def normal(n, arr):
    area = 0
    visit = [[0 for j in range(len(arr[0]))] for i in range(len(arr))]
    queue = []
    while True:
        nextI = 0
        nextJ = 0
        checked = False
        for i in range(n):
            if checked: break
            for j in range(n):
                if visit[i][j] == 0:
                    nextI = i
                    nextJ = j
                    checked = True
                    break
        if checked is False:
            break
        queue.append([nextI, nextJ])
        visit[nextI][nextJ] = 1
        while len(queue) > 0:
            q = queue.pop(0)
            color = arr[q[0]][q[1]]

            # 인접 노드 중 색깔 같은게 있는지 검사
            if q[0] > 0:
                if visit[q[0] - 1][q[1]] == 0 and arr[q[0] - 1][q[1]] == color:
                    queue.append([q[0] - 1, q[1]])
                    visit[q[0] - 1][q[1]] = 1
            if q[0] + 1 < n:
                if visit[q[0] + 1][q[1]] == 0 and arr[q[0] + 1][q[1]] == color:
                    queue.append([q[0] + 1, q[1]])
                    visit[q[0] + 1][q[1]] = 1
            if q[1] > 0:
                if visit[q[0]][q[1] - 1] == 0 and arr[q[0]][q[1] - 1] == color:
                    queue.append([q[0], q[1] - 1])
                    visit[q[0]][q[1] - 1] = 1
            if q[1] + 1 < n:
                if visit[q[0]][q[1] + 1] == 0 and arr[q[0]][q[1] + 1] == color:
                    queue.append([q[0], q[1] + 1])
                    visit[q[0]][q[1] + 1] = 1
        area += 1
    return area

n = int(input())
arr = []
for i in range(n):
    arr.append(input())

solution(n, arr)

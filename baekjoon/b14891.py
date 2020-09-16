# 0:50
def solution(arr, turn):
    for t in turn:
        arr = wheel(arr, t[0], t[1])
        #print(arr)

    point = count_point(arr)
    return point


def count_point(arr):
    point = 0
    if arr[0][0] == 1:
        point += 1
    if arr[1][0] == 1:
        point += 2
    if arr[2][0] == 1:
        point += 4
    if arr[3][0] == 1:
        point += 8
    return point


def wheel(arr, num, dir):
    visit = []
    queue = []
    queue.append([num, dir])
    while len(queue) > 0:
        q = queue.pop(0)
        #print(q)
        visit.append(q[0])

        if q[0] > 1 and q[0]-1 not in visit:
            if arr[q[0]-1][6] != arr[q[0]-2][2]:
                queue.append([q[0]-1, q[1]*-1])
        if q[0] < len(arr) and q[0]+1 not in visit:
            if arr[q[0]-1][2] != arr[q[0]][6]:
                queue.append([q[0]+1, q[1]*-1])

        if q[1] == 1:
            arr[q[0] - 1] = [arr[q[0] - 1][-1]] + arr[q[0] - 1][:-1]
        else:
            arr[q[0] - 1] = arr[q[0] - 1][1:] + [arr[q[0] - 1][0]]
        #print(arr)

    return arr

arr = [[]for j in range(4)]
for i in range(4):
    arr[i] = list(input())
    arr[i] = list(map(int, arr[i]))

k = int(input())
turn = [[] for j in range(k)]
for i in range(k):
    s = input().split(" ")
    turn[i] = [int(s[0]), int(s[1])]

print(solution(arr, turn))

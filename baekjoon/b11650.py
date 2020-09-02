import sys


# Quick sort
def solution(arr):
    if len(arr) <= 1:
        return arr
    pivot = len(arr) -1
    left = 0
    right = len(arr) -1

    while True:
        while arr[left][0] <= arr[pivot][0]:
            if arr[left][0] == arr[pivot][0]:
                if arr[left][1] > arr[pivot][1]:
                    break
            if left == len(arr)-1: break
            left += 1
        while arr[right][0] >= arr[pivot][0]:
            if arr[right][0] == arr[pivot][0]:
                if arr[right][1] < arr[pivot][1]:
                    break
            if right == 0: break
            right -= 1

        if left >= right:
            break
        else:
            arr[left], arr[right] = arr[right], arr[left]
    arr[left], arr[pivot] = arr[pivot], arr[left]
    return solution(arr[:pivot]) + [arr[pivot]] + solution(arr[pivot+1:])


n = int(input())
arr = [[0, 0] for i in range(n)]
for i in range(n):
    s = sys.stdin.readline().rstrip().split()
    arr[i][0] = int(s[0])
    arr[i][1] = int(s[1])

#arr = solution(arr)
# Quick sort로 풀면 시간 초과. 
arr = sorted(arr, key=lambda x: (x[0], x[1]))
for i in range(n):
    print(arr[i][0], arr[i][1])

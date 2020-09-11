# 0:09
def solution(k, n, arr):
    start = 1
    end = max(arr)
    max_len = 0

    while start <= end:
        mid = (start+end)//2
        total = 0
        for a in arr:
            if a >= mid:
                total += a // mid
        if total >= n:
            if mid > max_len:
                max_len = mid
            start = mid + 1
        else:
            end = mid - 1

    return max_len


i = input().split(' ')
k = int(i[0])
n = int(i[1])
arr = []
for i in range(k):
    arr.append(int(input()))

print(solution(k, n, arr))

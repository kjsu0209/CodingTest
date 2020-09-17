# 0:05
def solution(n, k, arr):

    total = 0
    count = 0
    while total < k:
        if arr[-1] + total > k:
            arr.pop()
            continue

        count += (k-total) // arr[-1]
        total += ((k-total) // arr[-1]) * arr[-1]
    return count



nk = list(map(int, input().split()))
arr = [0 for i in range(nk[0])]
for i in range(nk[0]):
    arr[i] = int(input())

print(solution(nk[0], nk[1], arr))

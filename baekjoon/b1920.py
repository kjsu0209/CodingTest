# 0:07
def solution(k, arr):
    start = 0
    end = len(arr)-1
    while start <= end:
        mid = (start + end)//2
        if arr[mid] < k:
            start = mid + 1
        elif arr[mid] > k:
            end = mid - 1
        else:
            return 1
    return 0


n = int(input())
arr = input().split()
arr = sorted(list(map(int, arr)))

m = int(input())
arr2 = input().split()
answer = []
for j in arr2:
    data = int(j)
    answer.append(solution(data, arr))

for i in answer:
    print(i)

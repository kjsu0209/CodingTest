# 정수 삼각형
# 점화식: N[i][j] = max(N[i-1][j-1], N[i-1][j]) or N[i-1][j]
n = int(input())
triangle = [[]for i in range(n)]
for i in range(n):
    triangle[i] = list(map(int, input().split()))

for i in range(1, n):
    for j in range(len(triangle[i])):
        if 0 < j < len(triangle[i-1]):
            triangle[i][j] += max(triangle[i-1][j-1], triangle[i-1][j])
        elif j == 0:
            triangle[i][j] += triangle[i-1][j]
        else:
            triangle[i][j] += triangle[i-1][-1]
            
print(max(triangle[n-1]))

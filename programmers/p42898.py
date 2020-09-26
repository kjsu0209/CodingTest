# 0:28
# 점화식: n[i][j] = n[i][j-1] + n[i-1][j]
def solution(m, n, puddles):
    answer = 0
    maps = [[0 for i in range(m)] for j in range(n)]
    for p in puddles:
        maps[p[1]-1][p[0]-1] = -1
    for i in range(n):
        for j in range(m):
            if maps[i][j] == -1:
                maps[i][j] = 0
                continue
            if i == 0 and j == 0:
                maps[i][j] = 1
            elif i == 0 and j > 0:
                maps[i][j] = maps[i][j-1]
            elif j == 0 and i > 0:
                maps[i][j] = maps[i-1][j]
            else:
                maps[i][j] = (maps[i-1][j] + maps[i][j-1]) % 1000000007
    return maps[n-1][m-1]

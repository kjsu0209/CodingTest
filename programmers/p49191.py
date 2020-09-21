# 0:18 Floyd Warshall
import math
def solution(n, results):
    answer = 0
    dist = [[math.inf for j in range(n)] for i in range(n)]
    for i in range(n):
        dist[i][i] = 0
    for r in results:
        dist[r[0]-1][r[1]-1] = 1
    
    # 거쳐가는 노드
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if dist[i][k] + dist[k][j] < dist[i][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]
    
    # 자식 이외의 모든 노드에서 접근 가능해야함
    for k in range(n):
        check = False
        for i in range(n):
            if dist[k][i] == math.inf and dist[i][k] == math.inf:
                check = True
        if check is False:
            answer += 1
    return answer

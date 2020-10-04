# 0:22
# dfs, bfs, bf

import copy
from collections import deque
def solution(n, m, maps, wall_count):
    if wall_count == 3:
        return spread_virus(n, m, maps)

    max_safe_zone = 0
    new_map = copy.deepcopy(maps)
    for i in range(n):
        for j in range(m):
            if new_map[i][j] == 0:
                new_map[i][j] = 1
                max_safe_zone = max(max_safe_zone, solution(n, m, new_map, wall_count + 1))
                new_map[i][j] = 0

    return max_safe_zone


def spread_virus(n, m, maps):
    queue = deque([])
    visit = [[False for i in range(m)] for j in range(n)]
    count = count_safe_zone(n, m, maps)
    for i in range(n):
        if len(queue) > 0: break
        for j in range(m):
            if maps[i][j] == 2:
                queue.append([i, j])
                visit[i][j] = True
                break

    direction = [[-1, 0], [0, 1], [1, 0], [0, -1]]
    while len(queue) > 0:
        q = queue.popleft()

        for d in direction:
            nextR = q[0] + d[0]
            nextC = q[1] + d[1]
            if 0 <= nextR < n and 0 <= nextC < m:
                if visit[nextR][nextC] is False and maps[nextR][nextC] != 1:
                    if maps[nextR][nextC] == 0:
                        count -= 1
                    queue.append([nextR, nextC])
                    visit[nextR][nextC] = True

        if len(queue) == 0:
            for i in range(n):
                if len(queue) > 0: break
                for j in range(m):
                    if visit[i][j] is False and maps[i][j] == 2:
                        queue.append([i, j])
                        visit[i][j] = True
                        break

    return count


def count_safe_zone(n, m, maps):
    count = 0
    for i in range(n):
        for j in range(m):
            if maps[i][j] == 0:
                count += 1
    return count


n, m = list(map(int, input().split()))
maps = []

for i in range(n):
    maps.append(list(map(int, input().split())))

print(solution(n, m, maps, 0))

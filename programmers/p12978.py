# 다익스트라
# 0:21

from collections import deque
import math
def solution(N, road, K):
    answer = 0
    
    next_county = [[] for i in range(N+1)]
    for r in road:
        next_county[r[0]].append([r[1], r[2]])
        next_county[r[1]].append([r[0], r[2]])
    
    dist = [math.inf for i in range(N+1)]
    dist[1] = 0
    
    queue = deque()
    queue.append([1, 0])
    while len(queue) > 0:
        q = queue.popleft()
        
        if q[1] > dist[q[0]]:
            continue
        
        for c in next_county[q[0]]:
            if q[1] + c[1] < dist[c[0]]:
                queue.append([c[0], q[1] + c[1]])
                dist[c[0]] = q[1] + c[1]
    
    for d in dist:
        if d <= K:
            answer += 1
    return answer

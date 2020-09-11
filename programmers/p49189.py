# 다익스트라
# 0: 35
import heapq
from queue import PriorityQueue

def solution(n, edge):
    answer = 0
    edge = sorted(edge)
    dist = {}
    heap = []
    near = {}
    for i in range(1, n+1):
        if i == 1:
            heapq.heappush(heap, (0, i))
            dist[i] = 0
        else:
            heapq.heappush(heap, (200000, i))
            dist[i] = 200000
    for e in edge:
        if e[0] in near.keys():
            near[e[0]].append(e[1])
        else:
            near[e[0]] = [e[1]]
        if e[1] in near.keys():
            near[e[1]].append(e[0])
        else:
            near[e[1]] = [e[0]]


    while len(heap) > 0:
        index = heapq.heappop(heap)
        if dist[index[1]] >= index[0]:
            if index[1] in near.keys():
                for e in near[index[1]]:
                    if dist[index[1]] + 1 < dist[e]:
                        heapq.heappush(heap, (dist[index[1]]+1, e))
                        dist[e] = dist[index[1]]+1 
                # if index[1] == e[0] and dist[e[0]] + 1 < dist[e[1]]:
                #     heapq.heappush(heap, (dist[e[0]]+1, e[1]))
                #     dist[e[1]] = dist[e[0]]+1
                # elif index[1] == e[1] and dist[e[1]] + 1 < dist[e[0]]:
                #     heapq.heappush(heap, (dist[e[1]]+1, e[0]))
                    #dist[e[0]] = dist[e[1]]+1
    dist = sorted(dist.items(), key=lambda x: x[1], reverse=True)
    max_val = dist[0][1]
    #print(max_val)
    for d in dist:
        if max_val == d[1]:
            answer+=1
        else:
            break
    return answer

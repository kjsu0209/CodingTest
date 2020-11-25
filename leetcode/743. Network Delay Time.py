# 0:20
# Runtime: 460 ms, faster than 64.07% of Python3 online submissions for Network Delay Time.
# Memory Usage: 16.2 MB, less than 12.40% of Python3 online submissions for Network Delay Time.
# priority queue dijkstra algorithm


import math, heapq

class Solution:
    def networkDelayTime(self, times: List[List[int]], N: int, K: int) -> int:
        # dijkstra
        dist = [math.inf for _ in range(N+1)]
        graph = {}
        
        queue = []
        dist[K] = 0
        for t in times:
            if t[0] in graph.keys():
                graph[t[0]].append([t[1], t[2]])
            else:
                graph[t[0]] = [[t[1], t[2]]]
                
            if t[0] == K:
                if dist[t[1]] > t[2]:
                    dist[t[1]] = t[2]
                heapq.heappush(queue, (t[2], t[1]))
                
        
        while len(queue) > 0:
            q = heapq.heappop(queue)
            if q[0] > dist[q[1]]:
                continue
            if q[1] not in graph.keys():
                continue
            
            for t in graph[q[1]]:
                if dist[t[0]] > t[1] + q[0]:
                    dist[t[0]] = t[1] + q[0]
                    heapq.heappush(queue, (t[1]+q[0], t[0]))
                        
        max_val = -1
        val_count = 0
        for d in dist:
            if d != math.inf:
                val_count += 1
                if d > max_val:
                    max_val = d
                
        if max_val == 0 or val_count < N:
            max_val = -1
        
        return max_val

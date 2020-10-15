# 0:20
import heapq
def solution(n, works):
    heap = []
    for w in works:
        heapq.heappush(heap, w*-1)
        
    time_left = n
    while time_left > 0:
        if len(heap) == 0: break
        h = heapq.heappop(heap)*-1
        if h > 0:
            h -= 1
            time_left -= 1
            heapq.heappush(heap, h*-1)
    
    answer = 0
    for h in heap:
        answer += h**2
    return answer

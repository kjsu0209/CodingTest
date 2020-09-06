# 0:20
import heapq
def solution(operations):
    answer = []
    max_heap = []
    min_heap = []
    for o in operations:
        s = o.split(" ")
        if s[0] == 'I':
            heapq.heappush(max_heap, (-int(s[1]), int(s[1])))
            heapq.heappush(min_heap, int(s[1]))
        elif s[0] == 'D':
            if len(max_heap) > 0:
                if s[1] == '1':
                    h = heapq.heappop(max_heap)[1]
                    index = min_heap.index(h)
                    del min_heap[index]
                elif s[1] == '-1':
                    h = heapq.heappop(min_heap)
                    index = max_heap.index((-h, h))
                    del max_heap[index]
            
    if len(max_heap) > 0:
        answer = [max_heap[0][1], min_heap[0]]
    else:
        answer = [0, 0]
    return answer

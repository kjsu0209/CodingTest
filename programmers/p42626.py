import heapq
def solution(scoville, K):
    answer = 0
    heap = []
    # Min Heap 만들기
    for i in range(len(scoville)):
        heapq.heappush(heap, scoville[i])
        
    heapq.heapify(heap)
    
    while len(heap) >1:
        if heap[0] >= K:
            break
        else:
            answer+=1
        #음식 섞기
        a = heapq.heappop(heap)
        b = heapq.heappop(heap)
        s = a + 2*b
        heapq.heappush(heap, s)
    
    if heap[0] < K:
        answer = -1
    return answer

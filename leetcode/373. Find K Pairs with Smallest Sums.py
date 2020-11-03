# 0:21
# Runtime: 368 ms, faster than 23.49% of Python3 online submissions for Find K Pairs with Smallest Sums.
# Memory Usage: 48.6 MB, less than 5.39% of Python3 online submissions for Find K Pairs with Smallest Sums.
import sys
class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        answer = []
        
        sequence = []
        for n in nums1:
            for m in nums2:
                sequence.append([n, m])
        
        sequence = sorted(sequence, key=lambda x: sum(x))
        
        if len(sequence) > 0:
            answer = sequence[:k]
        
        return answer

# Heap
# Runtime: 228 ms, faster than 36.66% of Python3 online submissions for Find K Pairs with Smallest Sums.
# Memory Usage: 39.7 MB, less than 5.39% of Python3 online submissions for Find K Pairs with Smallest Sums.
import heapq
class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        answer = []
        
        sequence = []
        for n in nums1:
            for m in nums2:
                heapq.heappush(sequence, (n+m, n, m))
        
        for i in range(k):
            if len(sequence) > 0:
                answer.append(list(heapq.heappop(sequence))[1:])
        
        return answer

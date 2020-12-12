# Runtime: 3388 ms, faster than 5.03% of Python3 online submissions for Count Number of Teams.
# Memory Usage: 83 MB, less than 5.14% of Python3 online submissions for Count Number of Teams.

from collections import deque
class Solution:
    def numTeams(self, rating: List[int]) -> int:
        count = 0
        queue = deque()
        
        for i, r in enumerate(rating):
            queue.append([i, [r], None]) # index, list, order
        
        while len(queue) > 0:
            q = queue.popleft()
            
            if len(q[1]) == 3:
                count += 1
                #print(q[1])
                continue
            
            for i in range(q[0]+1, len(rating)):
                if q[2] is None:
                    if rating[i] < rating[q[0]]:
                        queue.append([i, q[1] + [rating[i]], True]) # asc
                    elif rating[i] > rating[q[0]]:
                        queue.append([i, q[1] + [rating[i]], False]) # desc
                elif q[2] is True:
                    if rating[i] < rating[q[0]]:
                        queue.append([i, q[1] + [rating[i]], True]) # asc
                elif q[2] is False:
                    if rating[i] > rating[q[0]]:
                        queue.append([i, q[1] + [rating[i]], False]) # desc

        return count

# 0:03
# Runtime: 112 ms, faster than 51.31% of Python3 online submissions for Find the Distance Value Between Two Arrays.
# Memory Usage: 14.4 MB, less than 100.00% of Python3 online submissions for Find the Distance Value Between Two Arrays.
class Solution:
    def findTheDistanceValue(self, arr1: List[int], arr2: List[int], d: int) -> int:
        answer = 0
        check = False
        for i in range(len(arr1)):
            check = False
            for j in range(len(arr2)):
                if abs(arr1[i] - arr2[j]) <= d:
                    check = True
                    break
            if check is False:
                answer += 1
                    
                    
        return answer
                    
        

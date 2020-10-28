# 0:08
# Runtime: 44 ms, faster than 50.37% of Python3 online submissions for Detect Pattern of Length M Repeated K or More Times.
# Memory Usage: 14.1 MB, less than 100.00% of Python3 online submissions for Detect Pattern of Length M Repeated K or More Times.
class Solution:
    def containsPattern(self, arr: List[int], m: int, k: int) -> bool:
        repeat = 0
        for i in range(len(arr)):
            index = i
            pre = None
            while index < len(arr):
                a = arr[index:index+m]
                if pre != a:
                    pre = a
                    repeat = 1
                else:
                    repeat += 1
                    if repeat >= k:
                        return True
                index += m
                
        return False
        

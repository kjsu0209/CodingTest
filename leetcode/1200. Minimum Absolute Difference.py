# 0:06
# Runtime: 356 ms, faster than 38.63% of Python3 online submissions for Minimum Absolute Difference.
# Memory Usage: 28.1 MB, less than 42.65% of Python3 online submissions for Minimum Absolute Difference.
class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        arr = sorted(arr)
        
        mad = 2000001
        
        answer = []
        for i in range(len(arr)):
            for j in range(i+1, len(arr)):
                a = abs(arr[i] - arr[j])
                if a < mad:
                    mad = abs(arr[i] - arr[j])
                    answer = []
                    answer.append([arr[i], arr[j]])
                elif a == mad:
                    answer.append([arr[i], arr[j]])
                else:
                    break
        return answer

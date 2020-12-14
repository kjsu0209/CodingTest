# 0:03
# 이분탐색
# Runtime: 28 ms, faster than 70.87% of Python3 online submissions for Guess Number Higher or Lower.
# Memory Usage: 14.3 MB, less than 16.13% of Python3 online submissions for Guess Number Higher or Lower.


# The guess API is already defined for you.
# @param num, your guess
# @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
# def guess(num: int) -> int:

class Solution:
    def guessNumber(self, n: int) -> int:
        start = 1
        end = n
        
        while start <= end:
            mid = (start + end)// 2
            
            r = guess(mid)
            if r == 0:
                return mid
            elif r == -1:
                end = mid-1
            else:
                start = mid +1
                
        

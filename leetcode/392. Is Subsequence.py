# 0:04
# Runtime: 32 ms, faster than 61.64% of Python3 online submissions for Is Subsequence.
# Memory Usage: 14.2 MB, less than 56.10% of Python3 online submissions for Is Subsequence.
class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        t_index = 0
        s_index = 0
        
        while s_index < len(s) and t_index < len(t):
            if s[s_index] == t[t_index]:
                s_index += 1
            t_index += 1
        
        if s_index == len(s):
            return True
        else:
            return False

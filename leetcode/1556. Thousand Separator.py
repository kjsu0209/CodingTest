# 0:03
# Runtime: 24 ms, faster than 89.51% of Python3 online submissions for Thousand Separator.
# Memory Usage: 14.2 MB, less than 8.32% of Python3 online submissions for Thousand Separator.
class Solution:
    def thousandSeparator(self, n: int) -> str:
        s = str(n)
        s = s[::-1]
        answer = ''
        for i in range(1, len(s)+1):
            answer += s[i-1]
            if i%3 == 0 and i != len(s):
                answer += '.'
                
        return answer[::-1]

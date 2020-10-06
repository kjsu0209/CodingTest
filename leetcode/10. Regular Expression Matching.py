# Runtime: 60 ms, faster than 53.03% of Python3 online submissions for Regular Expression Matching.
# Memory Usage: 14.3 MB, less than 8.03% of Python3 online submissions for Regular Expression Matching.
import re
class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        index = 0
        while '**' in p:
            split_p = p.split('**')
            p = ''.join(split_p)
        
        if len(p) > 0:
            while p[0] == '*':
                if len(p) == 1: return False
                p = p[1:]
        
        r = re.compile('^' + p + '$')
        
        if len(r.findall(s)) > 0:
            return True
        else:
            return False

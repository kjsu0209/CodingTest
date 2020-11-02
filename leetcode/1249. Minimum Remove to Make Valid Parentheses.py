# 0:15
# Runtime: 88 ms, faster than 91.52% of Python3 online submissions for Minimum Remove to Make Valid Parentheses.
# Memory Usage: 15.9 MB, less than 5.46% of Python3 online submissions for Minimum Remove to Make Valid Parentheses.

class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        answer = ''
        stack = []
        removable = []
        
        for i, w in enumerate(s):
            if w == '(':
                stack.append(i)
            elif w == ')':
                if len(stack) > 0:
                    stack.pop()
                else:
                    removable.append(i)
        
        for st in stack:
            removable.append(st)
        
        removable = sorted(removable, reverse=True)
        index = 0
        while index < len(s) and len(removable)>0:
            r = removable.pop()
            answer += s[index:r]
            index = r+1
        if index < len(s):
            answer += s[index:]
        return answer

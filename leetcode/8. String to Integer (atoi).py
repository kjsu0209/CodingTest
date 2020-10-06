# Runtime: 24 ms, faster than 98.54% of Python3 online submissions for String to Integer (atoi).
# Memory Usage: 14.2 MB, less than 5.01% of Python3 online submissions for String to Integer (atoi).

class Solution:
    def myAtoi(self, s: str) -> int:
        if len(s) == 0: return 0
        
        while s[0] == ' ':
            if len(s) == 1: break
            s = s[1:]
        
        while True:
            if s[0] in ['+', '-']:
                if len(s) == 1: return 0
                if s[1].isdigit() is False:
                    return 0
                else:
                    break
            elif s[0].isdigit() is True:
                break
            else:
                return 0
        
        header = ''
        if s[0] == '-':
            header = '-'
            s = s[1:]
        elif s[0] == '+':
            s = s[1:]

        dot_occur = 0
        for i in range(len(s)):
            if s[i].isdigit() is False:
                if s[i] == '.':
                    if dot_occur == 0:
                        dot_occur += 1
                    else:
                        s = s[:i]
                        break
                else:
                    s = s[:i]
                    break
        
        if '.' in s:
            s = s.split('.')[0]
        
        while s[0] == '0':
            if len(s) == 1:
                if s[0] == '0':
                    return 0
                else:
                    break
            s = s[1:]
        
        overflow_pos = '2147483647'
        overflow_neg = '2147483648'
        
        if len(s) > len(overflow_pos):
            if header == '':
                return overflow_pos
            else:
                return header + overflow_neg
        elif len(s) == len(overflow_pos):
            if header == '':
                for i, j in zip(s, overflow_pos):
                    if int(i) > int(j):
                        return overflow_pos
                    elif int(i) < int(j):
                        break
            else:
                for i, j in zip(s, overflow_neg):
                    if int(i) > int(j):
                        return header + overflow_neg
                    elif int(i) < int(j):
                        break
        return header + s

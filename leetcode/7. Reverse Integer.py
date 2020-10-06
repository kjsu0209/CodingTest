import sys
class Solution:
    def reverse(self, x: int) -> int:
        header = ''
        n = str(x)
        
        if n[0] == '-':
            header = '-'
            n = n[1:]
        
        n = n[::-1]
        while n[0] == '0':
            if len(n) == 1:
                break
            n = n[1:]
        
        overflow_pos = '2147483647'
        overflow_neg = '2147483648'
        
        if header == '':
            if len(n) > len(overflow_pos):
                return 0
            elif len(n) == len(overflow_pos):
                for i,j in zip(n, overflow_pos):
                    if int(i) > int(j):
                        return 0
                    elif int(i) < int(j):
                        break
        else:
            if len(n) > len(overflow_neg):
                return 0
            elif len(n) == len(overflow_neg):
                for i,j in zip(n, overflow_neg):
                    print(i, j)
                    if int(i) > int(j):
                        return 0
                    elif int(i) < int(j):
                        break

        
        return int(header+n)

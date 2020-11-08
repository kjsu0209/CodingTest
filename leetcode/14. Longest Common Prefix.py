# 0:14
# 주석 부분은 prefix가 아니고 substring 기준일 경우 체크
# Runtime: 208 ms, faster than 6.69% of Python3 online submissions for Longest Common Prefix.
# Memory Usage: 14.2 MB, less than 100.00% of Python3 online submissions for Longest Common Prefix.
import re
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        min_str = ''
        
        for s in strs:
            if min_str == '':
                min_str = s
            else:
                if len(min_str) > len(s):
                    min_str = s
        total_n = len(strs)   
        max_prefix = ''
        
        for i in range(len(min_str)):
            for j in range(i+1,len(min_str)+1):
                s = min_str[i:j]
                #number = sum(list(map(lambda a: 1 if len(re.findall(s, a)) > 0 else 0 , strs)))
                check = False
                for k in strs:
                    if s != k[:len(s)]:
                        check = True
                        break
                
                #if number == total_n:
                if check is False:
                    if len(max_prefix) < len(s):
                        max_prefix = s
                        
        return max_prefix

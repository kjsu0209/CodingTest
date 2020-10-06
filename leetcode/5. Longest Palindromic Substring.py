class Solution:

    def longestPalindrome(self, s: str) -> str:
        
        for i in range(len(s)-1,-1,-1):
            start = 0
            end = i
            
            while end < len(s):
                right = s[start:end+1]
                if s[start:end+1] == right[::-1]:
                    return s[start:end+1]
                start+=1
                end+=1
                
        return s[0]
    
    

        

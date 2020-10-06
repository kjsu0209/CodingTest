class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        dictionary = {}
        for a in s:
            dictionary[a] = 0
        
        start = 0
        end = 0
        longest = 1
        if len(s) == 0: return 0
        dictionary[s[0]] +=1
        
        while start <= end < len(s)-1:
            longest = max(longest, len(s[start:end+1]))
            
            if s[start] == s[end+1]:
                end += 1
                start += 1
            else:
                if dictionary[s[end+1]] == 0:
                    dictionary[s[end+1]] += 1
                    end += 1
                else:
                    for i in range(start, end+1):
                        start += 1
                        if s[i] == s[end+1]:
                            break
                        dictionary[s[i]] = 0
                    end += 1
        longest = max(longest, len(s[start:end+1]))    
        
        return longest

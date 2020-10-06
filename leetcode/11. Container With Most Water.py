# Two Pointer
class Solution:
    def maxArea(self, height: List[int]) -> int:
        max_area = 0
        
        i = 0
        j = len(height) - 1
        
        while i < j:
            cur = min(height[i], height[j]) * (j-i)
            
            if cur > max_area:
                max_area = cur

            if height[i] > height[j]:
                j -= 1
            else:
                i += 1
                
        return max_area
        

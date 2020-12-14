# 0:05
# Runtime: 32 ms, faster than 69.42% of Python3 online submissions for Construct the Rectangle.
# Memory Usage: 14.3 MB, less than 17.63% of Python3 online submissions for Construct the Rectangle.

import math
class Solution:
    def constructRectangle(self, area: int) -> List[int]:
        width = 1
        height = area
        half = math.sqrt(area)
        answer = [width, height]
        
        while width <= half:
            if area % width == 0:
                answer[0] = width
                answer[1] = area // width
            width += 1
        
        return sorted(answer, reverse=True)

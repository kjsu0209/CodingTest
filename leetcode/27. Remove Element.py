# Runtime: 36 ms, faster than 35.58% of Python3 online submissions for Remove Element.
# Memory Usage: 14.2 MB, less than 55.02% of Python3 online submissions for Remove Element.

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        index = 0
        while index < len(nums):
            if nums[index] == val:
                nums.pop(index)
            else:
                index += 1
        return len(nums)
        

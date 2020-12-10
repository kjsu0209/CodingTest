# Runtime: 2008 ms, faster than 5.02% of Python3 online submissions for Remove Duplicates from Sorted Array.
# Memory Usage: 15.9 MB, less than 17.88% of Python3 online submissions for Remove Duplicates from Sorted Array.
# 0:05

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        index = 0
        while index < len(nums):
            if nums[index] in nums[index+1:]:
                nums.pop(index)
            else:
                index += 1
        return len(nums)

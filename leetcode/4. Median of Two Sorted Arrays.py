class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        index = 0
        median = [(len(nums1) + len(nums2))//2]
        answer = 0
        
        if (len(nums1) + len(nums2)) %2 == 0:
            median.append(median[0]-1)


        index1 = 0
        index2 = 0

        while index1 < len(nums1) and index2 < len(nums2):
            if nums1[index1] < nums2[index2]:
                if index in median:
                    answer += nums1[index1]
                index1 += 1
            elif nums1[index1] >= nums2[index2]:
                if index in median:
                    answer += nums2[index2]
                index2 += 1

            index += 1

        while index1 < len(nums1):
            if index in median:
                answer += nums1[index1]
            index1 += 1
            index += 1

        while index2 < len(nums2):
            if index in median:
                answer += nums2[index2]
            index2 += 1
            index += 1
            
        if (len(nums1) + len(nums2)) %2 == 0:
            answer = answer / 2

        return answer

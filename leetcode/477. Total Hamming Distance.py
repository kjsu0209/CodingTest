# 0:20
# Runtime: 456 ms, faster than 82.71% of Python3 online submissions for Total Hamming Distance.
# Memory Usage: 15.5 MB, less than 14.54% of Python3 online submissions for Total Hamming Distance.

class Solution:
    def totalHammingDistance(self, nums: List[int]) -> int:
        temp = 1 # bit 위치 검사용. 0001부터 시작해서 바깥 for문 돌때마다 이동
        answer = 0
        for i in range(32): # i번째 bit 검사
            zero = 0 # i번째 bit가 0인 bit 수
            one = 0 # i번째 bit가 1인 bit 수
            for n in nums:
                if n & temp == temp: # 1일 경우
                    one += 1
                else: #0일 경우
                    zero += 1
            
            answer += zero * one
            temp = temp << 1 # 1칸 이동
        return answer
                
                

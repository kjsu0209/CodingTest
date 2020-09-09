# 0:14
import sys
# 심사 받는데 걸리는 시간 기준으로 찾기
def solution(n, times):
    answer = sys.maxsize
    max_t = max(times)
    start = 0
    end = max_t * n # 제일 많이 걸리는 시간
    t = sys.maxsize
    while start <= end:
        mid = (start + end) // 2
        total = 0
        for i in range(len(times)):
             if mid >= times[i]: # 검사 시간이 적당할 경우
                    total += mid // times[i] # 시간당 검사할 수 있는 인원 체크
        if total >= n: # 목표치 달성
            if mid < t:
                t = mid
            end = mid - 1
        else:
            start = mid + 1
    
    return t

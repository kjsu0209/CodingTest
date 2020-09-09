# 0:32
def solution(stones, k):
    answer = 0
    start = 0
    end = max(stones) # 징검다리 건너는 사람 최대 수
    maxi = 0
    while start <= end:
        mid = (start + end) // 2
        #print('mid: ', mid)
        jump = 0
        total = 0
        for s in stones:
            if s < mid: # 뛰어넘어야 하는 경우
                jump += 1 # 점프 시작
            else:
                total = max(total, jump)
                jump = 0
        #print('jump: ', total)
        total = max(total, jump)
        if total >= k:
            end = mid - 1
        else:
            if maxi < mid:
                maxi = mid
            start = mid + 1
    return maxi

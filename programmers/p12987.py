# 0:12
def solution(A, B):
    answer = 0
    B = sorted(B)
    for a in A:
        start = 0
        end = len(B)-1
        value = -1
        while start <= end:
            mid = (start+end) // 2
            if B[mid] <= a:
                start = mid + 1
            else:
                value = mid
                end = mid - 1
        if value != -1:
            del B[value]
            answer+= 1
    
    return answer

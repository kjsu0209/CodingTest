# 0:20
def solution(A, K):
    # write your code in Python 3.6
    if len(A) == 0: return []
    if K >= len(A):
        shift = len(A) - (K % len(A))
        return A[shift:] + A[:shift]
    else:
        if K == 0:
            return A
        shift = len(A) - K
        return A[shift:] + A[0:shift:]

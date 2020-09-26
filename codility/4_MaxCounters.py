# 0:40
def solution(N, A):
    # write your code in Python 3.6
    answer = [0 for i in range(N)]
    max_counter = 0
    max_set = 0
    for a in A:
        if 1 <= a <= N:
            if answer[a-1] < max_set:
                answer[a-1] = 1 + max_set
            else:
                answer[a-1] += 1
            max_counter = max(answer[a-1], max_counter)
        else:
            max_set = max_counter

    for i, a in enumerate(answer):
        if a < max_set:
            answer[i] = max_set
    return answer

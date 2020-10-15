# 0:24
def solution(n, s):
    answer = []
    
    mid = s//n
    if mid > 0:
        for i in range(n):
            answer.append(mid)
        if s%n > 0:
            index = 0
            for i in range(s%n):
                if index == len(answer):
                    index = 0
                answer[index] += 1
                index += 1
                
    
    if len(answer) == 0:
        answer.append(-1)
    else:
        answer = sorted(answer)
    return answer

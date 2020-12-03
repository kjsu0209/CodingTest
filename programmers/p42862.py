# 0:19
def solution(n, lost, reserve):
    answer = 0
    
    student = [1 for _ in range(n)]
    
    for l in lost:
        student[l-1] -= 1
    
    for r in reserve:
        student[r-1] += 1
    
    index = 0
    count = 0
    while index < n:
        if student[index] == 0:
            borrow = False
            if index > 0:
                if student[index-1] == 2:
                    student[index] = 1
                    student[index-1] = 1
                    borrow = True
            if index < n-1 and borrow is False:
                if student[index+1] == 2:
                    student[index] = 1
                    student[index+1] = 1
                    borrow = True
            if borrow is True:
                count += 1
        index += 1
            
    for s in student:
        if s > 0:
            answer += 1
    
    return answer

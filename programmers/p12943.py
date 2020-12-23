# 0:03

def solution(num):
    answer = 0
    
    answer = collatz(num, 0)
    
    if answer == 500:
        answer = -1
        
    return answer

def collatz(num, count):
    if num == 1:
        return count
    if count == 500:
        return count
    
    if num%2 == 0:
        return collatz(num//2, count + 1)
    elif num%2 == 1:
        return collatz((num*3) +1, count + 1)

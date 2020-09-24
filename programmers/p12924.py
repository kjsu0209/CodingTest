# 0:20
def solution(n):
    answer = 0
    numbers = list(range(1, n+1))
    start = 0
    end = 0
    while start < n:
        value = sum(numbers[start:end+1])
        if value < n:
            end += 1
        elif value == n:
            answer += 1
            start += 1
            end = start
        else:
            start += 1
            end = start
    return answer

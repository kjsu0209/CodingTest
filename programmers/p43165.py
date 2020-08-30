def solution(numbers, target):
    answer = 0
    answer = dfs(numbers, target, 0, 0)
    return answer

def dfs(numbers, target, index, num):
    #print(index, num)
    if index >= len(numbers):
        if num == target:
            return 1
        else:
            return 0

    count = 0
    count += dfs(numbers, target, index+1, num+numbers[index])
    count += dfs(numbers, target, index+1, num-numbers[index])
    return count

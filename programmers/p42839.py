import math
all_numbers = []
def solution(numbers):
    global visit
    answer = 0
    answer = bp(numbers, '', [])
    return answer

def bp(numbers, num, visit):
    #print(num)
    global all_numbers
    count = 0
    
    if num in all_numbers:
        return 0

    #num이 소수인지 체크
    if len(num) > 0:
        all_numbers.append(num)
        n = int(num)
        check = True
        for i in range(2,int(math.sqrt(n))+1):
            if int(num)%i == 0:
                check = False
        if check == True and num != '1':
            #print(num, 'prime')
            count+=1
    
    if len(visit) == 0:
        visit = [0 for i in range(len(numbers))]
    for i in range(len(numbers)):
        if visit[i] == 0:
            #0으로 시작하면 안됨
            if(len(num)==0 and numbers[i] == '0'):
                continue
            #print(num, numbers[i], 'result', num + numbers[i])
            visit[i] = 1
            count += bp(numbers, num + numbers[i], visit)
            visit[i] = 0
    
    return count

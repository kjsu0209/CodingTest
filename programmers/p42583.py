# 0:28
def solution(bridge_length, weight, truck_weights):
    answer = 0
    queue = []
    finish = []
    n = len(truck_weights)
    
    while n != len(finish):
        if len(queue) > 0 :
            if answer - queue[0][0] == bridge_length:
                finish.append(queue.pop(0))
        if len(truck_weights) > 0:
            if q_sum(queue) + truck_weights[0] <= weight:
                queue.append([answer, truck_weights.pop(0)])
        #print(answer, finish, queue)
        answer += 1
        
    return answer

def q_sum(queue):
    result = 0
    for i in range(len(queue)): result += queue[i][1]
    return result

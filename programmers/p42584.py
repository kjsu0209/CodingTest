def solution(prices):
    answer = []
    length = len(prices)
    for i in range(length):
        answer.append(0)
        for j in range(i+1,length):
            #print(prices[i], prices[j])
            if prices[i]<=prices[j]:
                answer[i]+=1
            else:
                if i != length-1:
                    answer[i]+=1
                break
            
    return answer

def solution(people, limit):
    answer = 0  
    people.sort();
    # 양 끝에서 한칸씩 움직이면서 비교
    # 오버되면 무거운 쪽이 탑승
    left = 0
    right = len(people)-1
    
    while(left<=right):
        if people[left]+people[right] <= limit:
            answer += 1
            left+=1
            right-=1
        else:
            answer += 1
            right -=1
    
    return answer

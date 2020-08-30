def solution(msg):
    answer = []
    dic = {}
    max_dict = 26
    loop_till = -1
    for i in range(len(msg)):
        if loop_till > i:
            continue
        # 사전 검사 - 현재 입력
        if msg[i] not in dic.keys():
            dic[msg[i]] = ord(msg[i]) - 64
            if i == len(msg)-1:
                answer.append(dic[msg[i]])
                break

        # 사전 검사 - 다음 입력
        if i+1 < len(msg):
            if msg[i+1] not in dic.keys():
                dic[msg[i+1]] = ord(msg[i+1]) - 64
                max_dict += 1
                dic[msg[i:i+2]] = max_dict
                
                answer.append(dic[msg[i]])
                print('append ', msg[i])
                continue
                
        # 사전에 등록되어있는 가장 긴 문자열 찾기
        max_length = msg[i: i+1]
        found = False
        for j in range(i+1, len(msg)):
            if msg[i:j+1] not in dic.keys():
                max_dict += 1
                dic[msg[i:j+1]] = max_dict
                dic[msg[j]] = ord(msg[j])-64
                found = True
                break
            max_length = msg[i:j+1]
        
        if found == False and len(max_length) != 2:
            if i+len(max_length) == len(msg):
                loop_till = i+len(max_length)
            answer.append(dic[max_length])
        else:
            loop_till = i+ len(max_length)
            if i+len(max_length) >= len(msg) and len(max_length) == 2:
                if max_length[0] == max_length[1]:
                    max_length = max_length[:-1]
                    loop_till = i+ 2
            answer.append(dic[max_length])
    return answer

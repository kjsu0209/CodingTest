def solution(record):
    answer = []
    uid = {}
    log = []
    uid_log = {} #id별 로그
    new_log = [] #사용자 id만 담는 로그
    l_count = 0
    for r in record:
        strecord = r.split(' ')
        action_log = ""
        if strecord[0] == 'Enter':
            action_log = "님이 들어왔습니다."
            new_log.append(strecord[1])
            if strecord[1] in uid.keys():
                # 닉네임 갱신되었을 경우 이전 기록도 갱신
                if uid[strecord[1]] != strecord[2]:
                    uid[strecord[1]] = strecord[2]
                    # for i in range(len(log)):
                    #     if log[i][2] == strecord[1] and log[i][1] != strecord[2]:
                    #         log[i][0] = strecord[2]
                    for u in range(len(uid_log[strecord[1]])):
                        uid_log[strecord[1]][u][1] = strecord[2]
                #사용자별 로그에 추가
                udata = [len(uid_log[strecord[1]]), strecord[2], action_log]
                uid_log[strecord[1]].append(udata)
            else:
                uid[strecord[1]] = strecord[2]
                #사용자별 로그에 추가
                udata = [[0, strecord[2], action_log]]
                uid_log[strecord[1]] = udata
        elif strecord[0] == 'Change':
            if uid[strecord[1]] != strecord[2]:
                    uid[strecord[1]] = strecord[2]
                    for u in range(len(uid_log[strecord[1]])):
                        uid_log[strecord[1]][u][1] = strecord[2]
                        
        elif strecord[0] == 'Leave':
            action_log = "님이 나갔습니다."
            new_log.append(strecord[1])
            #사용자별 로그에 추가
            udata = [len(uid_log[strecord[1]]), uid[strecord[1]], action_log]
            uid_log[strecord[1]].append(udata)
    
    #print(log)
    #print(uid_log)
    
    history = {}
    for i in range(len(new_log)):
        if new_log[i] in history.keys():
            answer.append(uid_log[new_log[i]][history[new_log[i]]][1] + uid_log[new_log[i]][history[new_log[i]]][2])
            history[new_log[i]] += 1
        else:
            answer.append(uid_log[new_log[i]][0][1] + uid_log[new_log[i]][0][2])
            history[new_log[i]] = 1

    return answer

def solution(N, stages):
    answer = []
    record = {}

    s_list = []
    passed_num = 0
    for i in range(N, 0, -1):
        c = stages.count(i)
        if i == N:
            passed_num = stages.count(i+1)
        if c == 0:
            s_list.append([i, 0])
        else:
            s_list.append([i, getData([c, passed_num])])
        passed_num += c
    
    s_list.reverse()
    s_list = sorted(s_list, key=lambda x: (x[1]), reverse=True)
    #print(s_list)
    for i in range(len(s_list)):
        answer.append(s_list[i][0])
    
    return answer

def getData(a):
    if a[0]+a[1] == 0:
        return 1
    else:
        return a[0]/(a[0]+a[1])

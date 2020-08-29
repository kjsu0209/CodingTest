def solution(s):
    answer = []
    t_list = s.split('},{')
    t_list[0] = t_list[0][2:]
    t_list[-1] = t_list[-1][:-2]
    t_list = sorted(t_list, key=lambda t:len(t))
    
    for t in t_list:
        small_t = t.split(',')
        for num_t in small_t:
            if int(num_t) not in answer:
                answer.append(int(num_t))
    return answer

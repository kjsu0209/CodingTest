import heapq
def solution(jobs):
    answer = 0
    
    n = len(jobs)
    jobs = sorted(jobs, key=lambda x: (x[0], x[1]))
    
    # 하드디스크 작업 시작
    clock = 0
    time = -1
    timer = 1
    req_time = 0
    avg_time = 0
    wait_queue = []
    while (len(jobs) >= 1 or len(wait_queue) >= 1) or time!=-1:
        #print(clock, 'ticker :', timer, time)
        if time == timer:
            # 수행 종료
            avg_time += clock - req_time
            time = -1
            timer = 1
            req_time = 0
        elif time > timer:
            clock+=1
            timer+=1
            if len(jobs) > 0:
                # 작업중인데 요청 들어올 경우 대기열에 추가
                if jobs[0][0] <= clock:
                    k = 0
                    while k<len(jobs):
                        if jobs[k][0] <= clock:
                            a = jobs.pop(0)
                            heapq.heappush(wait_queue, [a[1], a[0]])
                        else:
                            break
            continue
        
        if len(jobs) > 0:
            if clock < jobs[0][0]: # 시점 해당되지 않을 경우 대기열 검사
                if len(wait_queue) > 0:
                    a = heapq.heappop(wait_queue)
                    req_time = a[1]
                    time = a[0]
            else:
                if len(wait_queue) == 0: #대기열 없고 시점 해당될 경우 바로 실행
                    a = jobs.pop(0)
                    req_time = a[0]
                    time = a[1]
                    print(clock, ': start ', a)
                    k = 0
                    while k<len(jobs):
                        if jobs[k][0] <= clock:
                            a = jobs.pop(0)
                            heapq.heappush(wait_queue, [a[1], a[0]])
                        else:
                            break
                else: # 시점 해당되지만 대기열이 있을 경우 대기열에 모두 추가 후 하나 빼서 시작
                    k = 0
                    while k<len(jobs):
                        if jobs[k][0] <= clock:
                            a = jobs.pop(0)
                            heapq.heappush(wait_queue, [a[1], a[0]])
                        else:
                            break
                    a = heapq.heappop(wait_queue)
                    req_time = a[1]
                    time = a[0]
        else:
            if len(wait_queue) > 0:
                a = heapq.heappop(wait_queue)
                req_time = a[1]
                time = a[0]
        clock+=1
            
    answer = avg_time//n
    return answer

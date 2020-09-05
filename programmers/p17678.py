# 0:37
import datetime
def solution(n, t, m, timetable):
    answer = ''
    timetable = sorted(timetable, key=lambda x: (int(x[:2]), int(x[3:])))
    print(timetable)
    board_index = 0
    for i in range(n):
        time = make_time(i, t)
        capa = 0
        for j in range(board_index, len(timetable)):
            crew = timetable[j]
            if capa >= m: break
            if int(crew[:2]) < int(time[:2]) or (int(crew[:2]) == int(time[:2]) and int(crew[3:]) <= int(time[3:])):
                if i == n-1 and capa == m-1:
                    #막차인데 사람 꽉 찰 경우
                    hour = int(crew[:2])
                    mins = int(crew[3:])-1
                    if mins < 0:
                        hour -= 1
                        mins = 59
                    d = datetime.datetime(2020, 1, 1, hour, mins)
                    answer = d.strftime('%H:%M')
                    #print('board con')
                    break
                #print('board ', timetable[j])
                capa += 1
                board_index += 1
        
        # 막차고 빈 자리 있을 경우
        if i == n-1 and answer == '':
            answer = time
            #print('board con')
    return answer

def make_time(n, t):
    time = n*t
    hour = 9 + time // 60
    mins = time % 60
    d = datetime.datetime(2018, 5, 19, hour, mins)
    return d.strftime('%H:%M')

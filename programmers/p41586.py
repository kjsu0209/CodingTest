def solution(progresses, speeds):
    answer = []
    
    count = 0
    exe_per = -1
    exe_time = -1
    while len(progresses) != 0:
        if exe_per == -1:
            exe_per = progresses.pop(0)
            exe_speed = speeds.pop(0)
            exe_time = get_exe_time(exe_per, exe_speed)
            count = 1
            continue

        if exe_time < get_exe_time(progresses[0], speeds[0]):
            answer.append(count)
            exe_per = progresses.pop(0)
            exe_speed = speeds.pop(0)
            exe_time = get_exe_time(exe_per, exe_speed)
            count = 1
            continue
        else:
            progresses.pop(0)
            speeds.pop(0)
            count += 1
    
    answer.append(count)
    
    return answer

def get_exe_time(per, speed):
    exe_time = (100 - per) // speed
    if (100 - per) % speed > 0:
        exe_time += 1
    return exe_time

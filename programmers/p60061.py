def solution(n, build_frame):
    answer = []
    
    for b in build_frame:
        #print(b)
        if b[3] == 0: #삭제
            if b[:3] in answer and b[2] == 0:
                # 기둥 삭제할 수 있는지 검사
                if [b[0], b[1]+1, 0] in answer and ([b[0]-1, b[1]+1, 1] not in answer and [b[0], b[1]+1, 1] not in answer):
                    continue
                if [b[0], b[1]+1, 1] in answer and ([b[0]+1, b[1], 0] not in answer and ([b[0]+1, b[1]+1, 1] not in answer or ([b[0]-1, b[1]+1, 1] not in answer))):
                    continue
                if [b[0]-1, b[1]+1, 1] in answer and ([b[0]-1, b[1], 0] not in answer and ([b[0]-2, b[1]+1, 1] not in answer or ([b[0], b[1]+1, 1] not in answer))):
                    continue
                    
                

                index = answer.index(b[:3])
                del answer[index]
                #print('del col ', b[:2])
            elif b[:3] in answer and b[2] == 1:
                if canRemove(answer, b[:3]) == False:
                    continue

                index = answer.index(b[:3])
                del answer[index]
                #print('del bo ', b[:2])
        elif b[3] == 1: # 추가
            if b[2] == 0: # 기둥
                if [b[0], b[1], 1] in answer or [b[0]-1, b[1], 1] in answer:
                    answer.append(b[:3])
                elif [b[0], b[1]-1, 0] in answer:
                    answer.append(b[:3])
                elif b[1] == 0:
                    answer.append(b[:3])
            elif b[2] == 1: # 보
                if [b[0], b[1]-1, 0] in answer or [b[0]+1, b[1]-1, 0] in answer:
                    answer.append(b[:3])
                elif [b[0]-1, b[1], 1] in answer and [b[0]+1, b[1], 1] in answer:
                    answer.append(b[:3])
    answer = sorted(answer, key=lambda x: (x[0], x[1], x[2]))
    if len(answer) == 0:
        answer = [[]]
    #print(answer)
    return answer

def canRemove(answer, b):
    if [b[0], b[1], 0] in answer and ([b[0], b[1]-1, 0] not in answer and [b[0]-1, b[1], 1] not in answer): # 기둥 받치고 잇을 경우
        return False
    if [b[0]+1, b[1], 0] in answer and ([b[0]+1, b[1]-1, 0] not in answer and [b[0]+1, b[1], 1] not in answer): # 기둥 받치고 잇을 경우
        return False
    if ([b[0]-1, b[1], 1] in answer and [b[0]-2, b[1], 1] in answer) and ([b[0]-1, b[1]-1, 0] not in answer and [b[0], b[1]-1, 0] not in answer):
        return False
    if [b[0]+1, b[1], 1] in answer and [b[0]+2, b[1], 1] in answer:
        if [b[0]+1, b[1]-1, 0] not in answer and [b[0]+2, b[1]-1, 0] not in answer:
            return False
    return True

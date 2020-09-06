# 0:20
def solution(brown, yellow):
    answer = []
    visit = []
    
    for y_ver in range(1, yellow):
        y_hor = yellow // y_ver
        if yellow % y_hor != 0: continue
        need_b = y_ver*2 + y_hor*2 + 4

        if need_b == brown:
            answer = [y_hor+2, y_ver+2]
            break
            
    if yellow == 1:
        y_ver = 1
        y_hor = yellow // y_ver
        need_b = y_ver*2 + y_hor*2 + 4
        
        if need_b == brown:
            answer = [y_hor+2, y_ver+2]
            
    return answer

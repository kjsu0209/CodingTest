//0:35
import re
def solution(files):
    answer = []
    # HEAD sort
    files = sorted(files, key=lambda x: (re.split('[0-9]', x, 1)[0].upper(), l_sort(x)))
    # NUMBER
    print(files)
    answer = files
    return answer

def l_sort(x):
    c = re.search('[0-9]', x)
    c = x[c.start()]
    s = re.split('[0-9]', x, 1)[1] # HEAD 제거
    s = re.split('[\D]', s, 1)[0] # NUMBER 추출
    s = c + s
    #print(s)
    if len(s) > 0:
        while s[0] == '0':
            s = s[1:]
            if len(s) == 0: return 0
        return int(s)
    else:
        return 0
    
    

# 0:15
from itertools import cycle

def solution(n, words):
    answer = [0,0]
    history = []
    pre = None
    count = 0
    for w, c in zip(words, cycle(range(1,n+1))):
        count += 1
        if pre == None:
            pre = w
            history.append(w)
            continue
        if w[0] != pre[-1] or w in history:
            #print(w)
            if count % n == 0:
                answer = [c, count //n]
            else:
                answer = [c, count // n+1]
            break
        else:
            history.append(w)
            pre = w
        
    return answer

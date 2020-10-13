# 0:23
def solution(n, stations, w):
    tel = 0
    index = 1
    for s in stations:
        if s-w <= index:
            index = s+w+1
        else:
            tel += (s-w - index) // (2*w+1)
            if (s-w - index) % (2*w+1) > 0:
                tel += 1
            index = s+w+1
    if index <= n:
        tel += (n - index+1) // (2*w+1)
        if (n - index+1) % (2*w+1) > 0:
            tel += 1

    return tel

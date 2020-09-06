# 0:05
import re
def solution(phone_book):
    answer = True
    
    for p in phone_book:
        pattern = '^' + p
        r = re.compile(pattern)
        number = len(list(filter(r.findall, phone_book)))
        if number > 1:
            return False
    return answer

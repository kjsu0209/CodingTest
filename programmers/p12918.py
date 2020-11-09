# 0:02
import re
def solution(s):
    answer = False
    if (len(s) == 4 or len(s) == 6) and len(re.findall('[0-9]', s)) == len(s):
        answer = True
    return answer

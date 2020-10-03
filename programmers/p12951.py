import re
def solution(s):
    s = s.lower()
    pattern = r'( [a-z])'
    toUppder = lambda pat: ' ' + pat.group(0)[1].upper()
    answer = re.sub(pattern, toUppder, s)
    if answer[0].isalpha() is True:
        answer = answer[0].upper() + answer[1:]
    return answer

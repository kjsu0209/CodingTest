# 0:05
def solution(s, n):
    answer = ''
    for w in s:
        if w == ' ':
            answer += ' '
            continue
        amount = ord(w)
        if amount < 97:
            amount = (amount-65 +n)% 26
            amount += 65
        else:
            amount = (amount-97+n) % 26
            amount += 97
        answer += chr(amount)
    return answer

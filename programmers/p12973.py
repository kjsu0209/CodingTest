# 0:20 스택

def solution(s):
    s = list(s)
    answer = 0
    index = 0
    pre = ''
    stack = []
    top = -1
    while index < len(s):
        if top == -1:
            if len(stack)-1 == top:
                stack.append(s[index])
            else:
                stack[0] = s[index]
            top += 1
        elif stack[top] == s[index]:
            top -= 1
        else:
            if len(stack)-1 == top:
                stack.append(s[index])
                top += 1
            else:
                stack[top+1] = s[index]
                top += 1
        index += 1
        #print(top, stack)

    if top == -1:
        answer = 1
    else:
        answer = 0
    return answer

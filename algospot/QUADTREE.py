# 0:38
# divide and conquer
def solution(quad, degree):
    # print(quad, degree)
    if len(quad) == 1:
        return quad

    stack = []
    i = degree
    count = 0
    while count < 4 and i < len(quad):
        if quad[i] == 'b' or quad[i] == 'w':
            stack.append(quad[i])
            i += 1
        else:
            result = solution(quad, i+1)
            i += len(result)+1
            stack.append('x' + result)
        count += 1

    stack = stack[len(stack)//2:] + stack[:len(stack)//2]

    value = ''.join(stack)

    return value


tc = int(input())
for t in range(tc):
    quad = input()
    print(solution(quad, 0))

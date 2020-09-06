# 1+@ days
# 긴 
import re, copy

max_value = 0
min_value = 0


def solution(expression):
    answer = 0
    e = re.split("[+*-]", expression)
    op = re.findall("[+*-]", expression)

    priority = []
    dfs(expression, op, priority)
    global max_value, min_value
    return max_value if abs(max_value) > abs(min_value) else abs(min_value)


def dfs(e, op, priority):
    if priority == None:
        priority = []
    if len(priority) == 3:
        #print(priority)
        price = get_price(e, op, priority)
        global max_value, min_value
        max_value = max(price, max_value)
        min_value = min(price, min_value)
        return

    p = copy.deepcopy(priority)
    # +
    if '+' not in p:
        p.append('+')
        dfs(e, op, p)
        del p[-1]
    if '-' not in p:
        p.append('-')
        dfs(e, op, p)
        del p[-1]
    if '*' not in p:
        p.append('*')
        dfs(e, op, p)
        del p[-1]
    return


def get_price(e, ops, priority):
    op = copy.deepcopy(ops)
    price = 0
    expression = e
    for o in priority:
        while o in expression:
            ex = re.split("[+*-]", expression)
            op = re.findall("[+*-]", expression)
            o_index = op.index(o)
            exp = ex[o_index] + o + ex[o_index + 1]
            result = cal(o, ex[o_index], ex[o_index + 1])
            if result < 0:
                result = result * -1
                result = '$' + str(result)
            expression = expression.replace(exp, str(result))
    if expression[0] == '$':
        expression = '-' + expression[1:]
    price = int(expression)
    return price


def cal(o, e1, e2):
    if e1[0] == '$':
        e1 = '-' + e1[1:]
    if e2[0] == '$':
        e2 = '-' + e2[1:]

    e1 = int(e1)
    e2 = int(e2)
    if o == '+':
        return e1 + e2
    elif o == '-':
        return e1 - e2
    else:
        return e1 * e2

    
 # 짧은 버전
import re, copy
from itertools import permutations

def solution(e):
    answer = 0
    priority = list(permutations(['+', '*', '-']))
    for prior in priority:
        expression = e
        for o in prior:
            while o in expression:
                ex = re.split("[+*-]", expression)
                op = re.findall("[+*-]", expression)
                o_index = op.index(o)
                ex1 = ex[o_index].replace('$', '-')
                ex2 = ex[o_index+1].replace('$', '-')
                exp = ex[o_index] + o + ex[o_index + 1]
                exp2 = ex1 + o + ex2
                result = eval(exp2)
                if result < 0:
                    result = result * -1
                    result = '$' + str(result)
                expression = expression.replace(exp, str(result))
        if expression[0] == '$':
            expression = '-' + expression[1:]
        price = int(expression)
        answer = max(abs(price), answer)
    return answer

# 0:14
count = 0
visit_num = []
def solution(nums):
    answer = -1

    global count
    dfs(nums, 0, [])
    
    return count

def dfs(nums, sum_val, visit):
    if visit == None:
        visit = []
    global count, visit_num
    if len(visit) == 3:
        if check_prime(sum_val) and set(visit) not in visit_num:
            count += 1
            visit_num.append(set(visit))
        return
    
    import copy
    v = copy.deepcopy(visit)
    for n in nums:
        if n not in v:
            v.append(n)
            dfs(nums, sum_val+n, v)
            del v[-1]
            

def check_prime(num):
    c = 0
    if num == 1:
        return False
    for n in range(2, num):
        if num % n == 0:
            c += 1
    if c > 0:
        return False
    else:
        return True

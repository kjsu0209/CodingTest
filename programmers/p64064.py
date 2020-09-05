# 0:39
import re, copy

all_visit = []
def solution(user_id, banned_id):
    answer = 0
    ban_list = []
    for b in banned_id:
        pattern = '^'
        pattern += b.replace('*', '.')
        pattern += '$'
        r = re.compile(pattern)
        newlist = list(filter(r.match, user_id))

        ban_list.append(newlist)
        #print(newlist)
    
        
    answer = dfs(len(banned_id), ban_list, [])
    return answer


def dfs(n, ban_list, visit):
    global all_visit
    if ban_list == None:
        return 0
    if visit == None:
        visit = []
    
    if n == len(visit):
        #print(visit)
        all_visit.append(set(visit))
        return 1
    
    vi = copy.deepcopy(visit)
    
    count = 0
    for b_li in range(len(ban_list)):
        if len(vi) != b_li: continue
        for b in ban_list[b_li]:
            if b not in visit:
                vi.append(b)
                if set(vi) in all_visit:
                    del vi[-1]
                    continue
                count += dfs(n, ban_list, vi)
                del vi[-1]
    
    return count

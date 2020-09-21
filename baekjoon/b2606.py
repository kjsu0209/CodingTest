# 0:27
n = int(input())
m = int(input())
arr = []
for i in range(m):
    arr.append(list(map(int, input().split())))

def dfs(n, m, arr, com, worm):
    count = 0
    #print(com, worm)

    if worm is None:
        worm = []
    # import copy
    # worm = copy.deepcopy(w)
    worm.append(com)
    for a in arr:
        if com == a[0] and a[1] not in worm:
            count += dfs(n, m, arr, a[1], worm)
        elif com == a[1] and a[0] not in worm:
            count += dfs(n, m, arr, a[0], worm)
    if count == 0:
        return 1
    else:
        return 1 + count


print(dfs(n, m, arr, 1, [])-1)

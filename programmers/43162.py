visit_node = []
def solution(n, computers):
    answer = 0
    global visit_node
    for i in range(0, n):
        visit = []
        answer += bfs(n, computers, i, visit, 0)
    return answer

def bfs(n, computers, node, visit, count):
    global visit_node
    if visit is None:
        visit = []
    if node in visit_node:
        return 0
    visit.append(node)
    visit_node.append(node)
    #print(visit)

    check = 0
    for i in range(0, n):
        #연결된 노드로 가기
        print(i)
        if i not in visit and computers[node][i]==1:
            check = 1
            count = bfs(n, computers, i, visit, count)
    
    if check == 0:
        #print('end of network: ', 1)
        return 1
    else:
        return count

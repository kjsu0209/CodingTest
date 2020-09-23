# Kruskal's
def solution(n, costs):
    answer = 0
    # Step 1: 간선을 무게 오름차순으로 정렬
    costs = sorted(costs, key=lambda x: x[2])
    result = [] # 선택한 간선 저장하는 배열
    i=0
    e=0
    parent = []
    rank = []
    # 부모 노드 초기값 저장
    for node in range(n):
        parent.append(node)
        rank.append(0)
    # 선택할 간선 수가 정점 수 -1이 될 때까지 반복
    while e < n-1:
        # 간선 값 저장 (u: 노드1, v: 노드2, w: 가중치)
        u,v,w = costs[i]
        # 간선 인덱스 다음으로
        i += 1
        # 사이클이 만들어지는지 확인 -> 루트 노드 구해서 두 노드의 루트 노드가 같을 경우 사이클로 판단
        x = find(parent, u)
        y = find(parent, v)
        # 사이클이 만들어지지 않을 경우
        if x != y:
            e += 1 # 선택한 간선 수 증가
            result.append([u,v,w]) # 선택 배열에 저장
            union(costs, parent, rank, x, y) # 부분집합 합치기
    for r in result:
        answer += r[2] # 선택된 간선 가중치 더하기
    return answer
            
def find(parent, i):
    if parent[i] == i:
        return i
    return find(parent, parent[i])

def union(costs, parent, rank, x, y):
    xroot = find(parent, x) # 루트 노드 구하기
    yroot = find(parent, y) # 루트 노드 구하기2
    
    # 랭크 값으로 비교해서 두 트리 합치기 -> 랭크 값이 작은게 아래로 오도록 함.
    if rank[xroot] < rank[yroot]: 
        parent[xroot] = yroot
    elif rank[xroot] > rank[yroot]:
        parent[yroot] = xroot
    else:
        parent[yroot] = xroot
        rank[xroot] += 1 # 랭크가 같을 경우 부모 노드로 정한 노드의 랭크값 올리기

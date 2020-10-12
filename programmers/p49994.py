# 0:21
def solution(dirs):
    answer = 0
    direction = {'U':0, 'D':1, 'R':2, 'L':3}
    distance = [[1, 0], [-1,0],[0,1],[0,-1]]
    location = [0, 0]
    visit = [[[] for _ in range(11)] for _ in range(11)]
    for d in dirs:
        move = distance[direction[d]]
        newY = location[0] + move[0]
        newX = location[1] + move[1]
        
        if -5 <= newY <= 5 and -5 <= newX <= 5:
            #print(newY, newX)
            if location not in visit[newY + 5][newX + 5]:
                answer += 1
                visit[newY+5][newX+5].append(location)
                visit[location[0]+5][location[1]+5].append([newY, newX])
            location = [newY, newX]
        
    return answer

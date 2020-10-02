# 0:40

def solution(n, apple, move):
    snake = [[0, 0]]
    head = 1
    time = 0
    while True:
        #print(snake[0])
        direction = 'X'
        if len(move) > 0:
            if move[0][0] == time:
                if move[0][1] == 'D':
                    direction = 'D'
                else:
                    direction = 'L'
                move.pop(0)

        new_pos = next_pos(snake[0], direction, head)
        new_head = next_head(direction, head)
        if new_pos[0] < 0 or new_pos[0] >= n or new_pos[1] < 0 or new_pos[1] >= n:
            #print('bump!')
            time += 1
            break
        if new_pos in snake:
            time += 1
            #print('bite itself')
            break

        snake.insert(0, new_pos)
        if new_pos in apple:
            del apple[apple.index(new_pos)]
        else:
            snake.pop()
        head = new_head
        time += 1

    return time


def next_head(direction, h):
    head = h
    if direction == 'D':
        head += 1
        if head > 3:
            head = 0
    elif direction == 'L':
        head -= 1
        if head < 0:
            head = 3
    return head

def next_pos(snake, direction, head):
    new_pos = []
    turnX = [[-1,0],[0,1],[1,0],[0,-1]]
    turnL = [[0,-1],[-1,0],[0,1],[1,0]]
    turnD = [[0,1],[1,0],[0,-1],[-1,0]]

    if direction == 'X':
        new_pos = [snake[0]+turnX[head][0],snake[1]+turnX[head][1]]
    elif direction == 'D':
        new_pos = [snake[0]+turnD[head][0],snake[1]+turnD[head][1]]
    elif direction == 'L':
        new_pos = [snake[0]+turnL[head][0],snake[1]+turnL[head][1]]

    return new_pos


n = int(input())
k = int(input())
apple = []
for i in range(k):
    a = list(map(int, input().split()))
    apple.append([a[0]-1, a[1]-1])
l = int(input())
move = []
for i in range(l):
    m = input().split()
    move.append([int(m[0]), m[1]])

print(solution(n, apple, move))

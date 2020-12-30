# 0:34
# dfs로 블록을 보드에 하나씩 배치해 본다.
# can_place_block은 블록이 보드에 들어가는지 확인하는 메소드.
# 배열 block: 블록 모양별 좌표.

def solution(h, w, r, c, board):
    if r == h-1 and c == w-1:
        for i in range(h):
            for j in range(w):
                if board[i][j] == '.':
                    return 0
        return 1

    if board[r][c] == "#":
        if c < w - 1:
            return solution(h, w, r, c + 1, board)
        else:
            return solution(h, w, r + 1, 0, board)

    count = 0

    block = [[[0,0],[1,-1],[1,0]], [[0,0],[0,1],[1,0]],[[0,0],[0,1],[1,1]],[[0,0],[1,0],[1,1]],[[0,0],[0,-1],[-1,-1]]]

    for b in block:
        if can_place_block(b, h, w, r, c, board):
            x = [[r + b[0][0], c + b[0][1]], [r + b[1][0], c + b[1][1]], [r + b[2][0], c + b[2][1]]]

            for pos in x:
                board[pos[0]][pos[1]] = '#'
            if c < w-1:
                count += solution(h, w, r, c+1, board)
            else:
                count += solution(h, w, r+1, 0, board)
            for pos in x:
                board[pos[0]][pos[1]] = '.'

    return count


def can_place_block(b, h, w, r, c, board):
    x = [[r+b[0][0], c + b[0][1]],[r+b[1][0], c + b[1][1]],[r + b[2][0], c + b[2][1]]]

    for item in x:
        if 0<= item[0] < h and 0<= item[1] < w:
            if board[item[0]][item[1]] == '#':
                return False
        else:
            return False

    return True


c = int(input())

for tc in range(c):
    h, w = list(map(int, input().split(' ')))
    board = []
    for i in range(h):
        board.append(list(input()))

    print(solution(h, w, 0, 0, board))

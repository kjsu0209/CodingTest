# 1) 분할정복 개념따라 그대로 구현 (시간초과)
# 1:20
# base case: 울타리 범위 1일 때
# divide: 1이 아닐 때 범위를 좁혀서 나눈다.

def solution(start, end, fence):
    if start == end:
        return [fence[start], start, end]

    # 한 칸씩 좁히기, 좁힌 부분에서 얻을 수 있는 최대 넓이 직사각형 정보 리턴
    left = solution(start+1, end, fence)
    left_space = get_space(left)
    right = solution(start, end-1, fence)
    right_space = get_space(right)

    if left[1] == start+1: # 좁힐때 뺀 부분을 붙여도 되는지 확인
        if left[0] <= fence[start]:
            left_space += left[0]
            left[1] = start
        else:
            if left_space < fence[start] * (left[2] - left[1] + 1):
                left_space = fence[start] * (left[2] - left[1] + 1)
                left[0] = fence[start]
                left[1] = start

    if right[2] == end-1:
        if right[0] <= fence[end]:
            right_space += right[0]
            right[2] = end
        else:
            if right_space < fence[end] * (right[2] - right[1] + 1):
                right_space = fence[end] + (right[2] - right[1] + 1)
                right[0] = fence[end]
                right[2] = end

    if right_space < left_space:
        return left
    else:
        return right


def get_space(result):
    return result[0] * (result[2] - result[1] + 1)


tc = int(input())
for t in range(tc):
    n = int(input())
    fence = list(map(int, input().split(' ')))
    result = solution(0, len(fence)-1, fence)
    print(result[0] * (result[2] - result[1] + 1))

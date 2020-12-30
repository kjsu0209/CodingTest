# 0:04
# 주어진 문자열에서 두 글자씩 끊어서 따로 배열에 저장하였음.
# 배열을 정렬한 후, join 메서드로 하나의 문자열로 만들었음.
# 문자열 길이를 n이라고 하면, O(n/2 + (n/2)log(n/2))의 시간복잡도를 가진다.
# 배열을 사용했기 때문에 공간 복잡도는 O(n/2)이다.

t = int(input())

for test in range(t):
    string = input()
    arr = []
    index = 0

    while index < len(string):
        arr.append(string[index:index+2])
        index += 2

    arr = sorted(arr)
    print(''.join(arr))

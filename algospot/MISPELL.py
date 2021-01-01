# 0:02

n = int(input())

string = []

for i in range(n):
    index, s = list(input().split(' '))
    index = int(index) -1

    s = s[:index] + s[index + 1:]

    string.append(s)

for i, s in enumerate(string):
    print(i + 1, s)

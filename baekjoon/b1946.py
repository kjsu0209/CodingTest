import sys


def solution(results):
    answer = 1
    results = sorted(results, key=lambda x: x[0])
    minR = results[0][1]
    for i in range(1, len(results)):
        if results[i][1] < minR:
            minR = results[i][1]
            answer+=1
    return answer


t = int(input())
l = []

for i in range(t):
    n = int(input())
    results = [[0,0] for j in range(n)]
    for j in range(n):
        s = sys.stdin.readline().rstrip().split()
        results[j][0] = int(s[0])
        results[j][1] = int(s[1])
    l.append(solution(results))

for i in range(len(l)):
    print(l[i])

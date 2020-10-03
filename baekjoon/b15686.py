# 1:25

import sys
from itertools import combinations
init = input().split()
n = int(init[0])
m = int(init[1])
citymap = []


for i in range(n):
    citymap.append(list(map(int, input().split())))

house = []
chicken = []
for i in range(len(citymap)):
    for j in range(len(citymap)):
        if citymap[i][j] == 1:
            house.append([i, j])
        elif citymap[i][j] == 2:
            chicken.append([i, j])

house_combi = list(combinations(chicken, m))
total = sys.maxsize
for combi in house_combi:
    min_dist = sys.maxsize
    count = 0
    for h in house:
        min_dist = sys.maxsize
        for c in combi:
            dist = abs(h[0] - c[0]) + abs(h[1] - c[1])
            min_dist = min(dist, min_dist)
        count += min_dist
    total = min(total, count)
print(total)

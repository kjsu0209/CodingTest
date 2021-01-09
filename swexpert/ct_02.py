# x+y+z=100의자연수해를모두출력하는프로그램을작성

from itertools import permutations

combi = permutations(list(range(1, 8)), 3)

for c in combi:
    if sum(c) == 10:
        print(c)

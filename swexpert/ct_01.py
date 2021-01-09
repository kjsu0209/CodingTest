# 52장의카드에서만들수있는페어가정확히하나만있는5장조합을모두출력하는프로그램을작성하라. 출력이너무많으면카드수를줄일수있다


card = []
kind = ['H', 'S', 'D', 'C']
for j in range(4):
    name = kind[j]
    for i in range(1,7):
        card.append([name, i])

from itertools import combinations

def make_card(card, pair):
    if pair is None:
        pair = []

    combi = combinations(card, 5)
    for c in combi:
        if check_pair(c) is True:
            print(c)



def check_pair(pair):
    pair_count = 0
    combi = combinations(pair, 2)

    for c in combi:
        if c[0][1] == c[1][1]:
            pair_count += 1

    if pair_count == 1:
        return True
    else:
        return False


make_card(card, [])

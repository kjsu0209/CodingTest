
# m개의원소를가진집합에서n개의원소를가진집합으로가는전사함수의개수를출력하는프로그램을작성하라. 
# m과n의값을바꾸어보면서값이너무커지지않는입력의범위가어느정도인지확인해보라
# mHn = m+n-1Cn

m = int(input())
n = int(input())

import math

print(math.factorial(m+n-1) // (math.factorial(n)))

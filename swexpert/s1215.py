#import sys

#sys.stdin = open("input.txt", "r")

def solution(arr, t):
	count = 0
	for i in range(8):
		count += count_str(arr[i], t)
		new_str = ''
		for j in range(8):
			new_str += arr[j][i]
		count += count_str(new_str, t)
	return count


def count_str(s, t):
    count = 0
    start = 0
    end = t-1
    while end < len(s):
        check = False
        for i in range(t//2):
            #print(i, t, start+i,end-i)
            if s[start+i] != s[end-i]:
                check = True
        if check == False:
            count += 1
        start += 1
        end += 1
    #print(count)
    return count
        
        
T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    t = int(input())
    arr = []
    for i in range(8):
        arr.append(list(input()))
    print('#' + str(test_case), solution(arr, t))
    # ///////////////////////////////////////////////////////////////////////////////////
    


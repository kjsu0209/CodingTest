# 0:23

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    n, k = list(map(int, input().split()))
    num = list(input())
    arr = []
    for turn in range(n//4):
        for i in range(0, n, n//4):
	        arr.append(int('0x' + ''.join(num[i:i+n//4]), 16))
        num = num[1:] + [num[0]]
    arr = list(set(arr))
    arr = sorted(arr, reverse=True)
    print('#'+str(test_case), arr[k-1]) 
    # ///////////////////////////////////////////////////////////////////////////////////

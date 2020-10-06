class Solution:
    def convert(self, s: str, numRows: int) -> str:
        arr_depth = numRows+numRows-2
        if arr_depth < 0:
            arr_depth = 1
        arr = [[] for i in range(numRows)]
        s = list(s)
        repeat = list(range(numRows))
        repeat_reverse = repeat[::-1]
        repeat += repeat_reverse[1:-1]
        
        for i, j in zip(cycle(repeat), range(len(s))):
            arr[i].append(s[j])
        
        arr = list(map(''.join, arr))
        arr = ''.join(arr)

        return arr

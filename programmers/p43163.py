#  dfs같은 bfs
min_change = 55
def solution(begin, target, words):
    global min_change
    answer = 0
    if target not in words:
        return 0
    dfs(begin, target, words, 0)
    answer = min_change
    return answer

def dfs(begin, target, words, count):
    global min_change
    if begin == target:
        min_change = min(min_change, count)
        return
    
    for i in range(len(begin)):
        if target[i] == begin[i]:
            continue
        # a부터 z까지 i 인덱스에 넣어보면서 words에 있는지 비교하기
        for j in range(1,27):
            asc = chr(j+97)
            new_ch = begin[:i] + asc + begin[i+1:]
            if new_ch in words and new_ch != begin:
                words.remove(new_ch)
                dfs(new_ch, target, words, count+1)
                words.append(new_ch)
            

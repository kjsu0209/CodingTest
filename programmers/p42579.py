import operator

def solution(genres, plays):
    answer = []
    count = {}
    gen_count = {}
    for i in range(len(genres)):
        if genres[i] in count.keys():
            data = [i, plays[i]] # 고유번호, 재생횟수
            count[genres[i]].append(data)
            gen_count[genres[i]] += plays[i]
        else:
            count[genres[i]] = [[i, plays[i]]]
            gen_count[genres[i]] = plays[i]
    for g in count.keys():
        count[g]= sorted(count[g], key=lambda c: (c[1]), reverse=True)
    #딕셔너리 소팅
    gen_count = sorted(gen_count.items(), key=operator.itemgetter(1), reverse=True)
    #노래 수록
    for g in gen_count:
        num = 0
        for j in range(len(count[g[0]])):
            if num == 2: break
            answer.append(count[g[0]][j][0])
            num+=1
    #print(gen_count)
    return answer

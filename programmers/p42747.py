def solution(citations):
    answer = 0
    citations.sort()
    index = 0
    for c in range(citations[-1]):
        # h번 이상 인용된 논문이 h편 이상일 때
        if citations[index] < c:
            index += 1
        elif index <= c and len(citations)-index >= c:
            answer = c
    return answer

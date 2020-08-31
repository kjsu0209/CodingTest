def solution(tickets):
    answer = []
    answer = bfs(tickets, ['ICN'])
    return answer

def bfs(tickets, trace):
    if len(trace) == 0:
        trace = []
    if len(tickets) == 0:
        return trace
    able_airports = []
    for i in range(len(tickets)):
        if tickets[i][0] != trace[-1]:
            continue
        else:
            able_airports.append(i)
    able_airports = sorted(able_airports, key=lambda c: tickets[c][1])
    print(trace[-1],tickets, able_airports)
    if len(able_airports) == 0:
        return 0
    for a in able_airports:
        t = tickets[a]
        trace.append(tickets[a][1])
        del tickets[a]
        result = bfs(tickets, trace)
        if result == 0 or result == None:
            tickets.insert(a, t)
            del trace[-1]
        else:
            return result

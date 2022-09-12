
def solution(dist):
    answer = []

    m = 0
    start = 0

    N = len(dist)
    for i in range(N):
        for j in range(N):
            if m < dist[i][j]:
                m = dist[i][j]
                start = i
    
    tmp = []

    mV = 100000000
    for i in range(N):
        m = min(dist[start])
        idx = dist[start].index(m)
        tmp.append(idx)
        dist[start][idx] = mV

    answer.append(tmp)
    tmp2 = []
    for i in reversed(tmp):
        tmp2.append(i)
    answer.append(tmp2)

    return answer

print(solution([[0,5,2,4,1],[5,0,3,9,6],[2,3,0,6,3],[4,9,6,0,3],[1,6,3,3,0]]))
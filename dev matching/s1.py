def solution(rows, columns, connections, queries):
    answer = []
    for c in connections:
        c.append(0)
    for q in queries:
        l = min(q[1],q[3])-1
        r = max(q[1],q[3])
        u = min(q[0],q[2])-1
        d = max(q[0],q[2])

        cnt = 0

        for c in connections:
            if c[4] == 1:
                continue
            x1,y1,x2,y2 = c[:4]
            if x1 == x2 and (u < x1 <= d):
                y = min(y1,y2)
                if y == l or y == r:
                    cnt += 1
                    c[4] = 1
            elif y1 == y2 and (l < y1 <= r):
                x = min(x1,x2)
                if x == u or x == d:
                    cnt += 1
                    c[4] = 1

        answer.append(cnt)

    return answer


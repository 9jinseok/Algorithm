def solution(cakes, cut_rows, cut_columns):
    n = len(cut_rows)+1
    m = len(cut_columns)+1
    res = [[0]*m for _ in range(n)]

    cut_columns.insert(0,0)
    cut_columns.append(len(cakes))
    cut_rows.insert(0,0)
    cut_rows.append(len(cakes))

    for i in range(n):
        for j in range(m):
            s = set()
            for a in range(cut_rows[i],cut_rows[i+1]):
                for b in range(cut_columns[j],cut_columns[j+1]):
                    s.add(cakes[a][b])
            res[i][j] = len(s)
    ans = 0
    for i in res:
        tmp = max(i)
        if ans < tmp:
            ans = tmp
    return ans

print(solution(["AAAACX", "AAAACX", "AAAACX", "ZZZZZX", "ATTTTX", "XUUUUU"],[1, 2, 4],[2, 3]))
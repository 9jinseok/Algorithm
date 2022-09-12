def solution(rc, operations):
    r = len(rc)
    c = len(rc[0])
    for op in operations:
        if op == 'ShiftRow':
            tmp = [rc[-1]]
            for i in range(r - 1):
                tmp.append(rc[i])
            rc = tmp[:]
        else:
            rt = rc[0][-1]
            lb = rc[-1][0]

            for i in range(c - 1, 0, -1):
                rc[0][i] = rc[0][i-1]
            for i in range(c - 1):
                rc[-1][i] = rc[-1][i+1]
            for i in range(r - 1, 0, -1):
                rc[i][-1] = rc[i-1][-1]
            for i in range(r - 1):
                rc[i][0] = rc[i+1][0]

            rc[-2][0] = lb
            rc[1][-1] = rt

    return rc

print(solution([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]], ["ShiftRow", "Rotate"]))
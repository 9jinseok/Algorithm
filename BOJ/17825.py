#시간초과 (쓸데 없는 경우의수가 많음)
#중복순열로 하지말고 각 cctv별로 가능한 방향을 배열로 만들어서 그 안에서 조합을 구하자

import copy
from itertools import product

N, M = map(int,input().strip().split())
m = []

dx = [0, -1, 0, 1]
dy = [-1, 0, 1, 0]

cctv = []

res = N * M

for i in range(N):
    data = list(map(int, input().split()))
    m.append(data)
    for j in range(M):
        if data[j] in [1, 2, 3, 4, 5]:
            cctv.append([data[j], i, j])

Ncctv = len(cctv)
for d in product(range(4),repeat=Ncctv):
    copyM = copy.deepcopy(m)
    for i in range(Ncctv):
        if cctv[i][0] == 1:
            x_ = cctv[i][1] + dx[d[i]]
            y_ = cctv[i][2] + dy[d[i]]
            while 0 <= x_ < N and 0 <= y_ < M and copyM[x_][y_] != 6:
                if copyM[x_][y_] == 0:
                    copyM[x_][y_] = -1
                x_, y_ = x_ + dx[d[i]], y_ + dy[d[i]]
        elif cctv[i][0] == 2:
            for di in range(2):
                x_ = cctv[i][1] + dx[(d[i] + di*2) % 4]
                y_ = cctv[i][2] + dy[(d[i] + di*2) % 4]
                while 0 <= x_ < N and 0 <= y_ < M and copyM[x_][y_] != 6:
                    if copyM[x_][y_] == 0:
                        copyM[x_][y_] = -1
                    x_, y_ = x_ + dx[(d[i] + di*2) % 4], y_ + dy[(d[i] + di*2) % 4]
        elif cctv[i][0] == 3:
            for di in range(2):
                x_ = cctv[i][1] + dx[(d[i] + di) % 4]
                y_ = cctv[i][2] + dy[(d[i] + di) % 4]
                while 0 <= x_ < N and 0 <= y_ < M and copyM[x_][y_] != 6:
                    if copyM[x_][y_] == 0:
                        copyM[x_][y_] = -1
                    x_, y_ = x_ + dx[(d[i] + di) % 4], y_ + dy[(d[i] + di) % 4]
        elif cctv[i][0] == 4:
            for di in range(3):
                x_ = cctv[i][1] + dx[(d[i] + di) % 4]
                y_ = cctv[i][2] + dy[(d[i] + di) % 4]
                while 0 <= x_ < N and 0 <= y_ < M and copyM[x_][y_] != 6:
                    if copyM[x_][y_] == 0:
                        copyM[x_][y_] = -1
                    x_, y_ = x_ + dx[(d[i] + di) % 4], y_ + dy[(d[i] + di) % 4]
        elif cctv[i][0] == 5:
            for di in range(4):
                x_ = cctv[i][1] + dx[(d[i] + di) % 4]
                y_ = cctv[i][2] + dy[(d[i] + di) % 4]
                while 0 <= x_ < N and 0 <= y_ < M and copyM[x_][y_] != 6:
                    if copyM[x_][y_] == 0:
                        copyM[x_][y_] = -1
                    x_, y_ = x_ + dx[(d[i] + di) % 4], y_ + dy[(d[i] + di) % 4]

    cnt = 0
    for i in range(N):
        cnt += copyM[i].count(0)
    res = min(res,cnt)

print(res)
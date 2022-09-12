import sys
import copy
from collections import deque
from itertools import product

sys.stdin = open("input.txt", "r", encoding="UTF-8")

def delete(x, y, length, m):
    q = deque()
    m[x][y] = 0
    q.append([x,y,length])

    while q:
        x, y, length = q.popleft()

        for i in range(x - length + 1, x + length):
            if 0 <= i < H:
                if m[i][y] > 1:
                    q.append([i, y, m[i][y]])
                m[i][y] = 0
        for i in range(y - length + 1, y + length):
            if 0 <= i < W:
                if m[x][i] > 1:
                    q.append([x, i, m[x][i]])
                m[x][i] = 0

def gravity(m):
    for i in range(W):
        for j in range(H - 2, -1, -1):
            if m[j][i] != 0:
                j_ = j
                for k in range(j, H):
                    if k+1 == H or m[k+1][i] != 0:
                        j_ = k
                        break
                tmp = m[j][i]
                m[j][i] = 0
                m[j_][i] = tmp

T = int(input())
for t in range(1, T+1):
    N, W, H = map(int,input().strip().split())
    m = [list(map(int,input().strip().split())) for _ in range(H)]

    res = W * H
    for shoot in product(range(W), repeat = N):
        copyM = copy.deepcopy(m)

        for y in shoot:
            x = 0
            while x < H and copyM[x][y] == 0:
                x += 1

            if x < H:
                delete(x, y, copyM[x][y], copyM)
                gravity(copyM)

        zeroCnt = 0
        for i in range(H):
            zeroCnt += copyM[i].count(0)

        res = min(res, W * H - zeroCnt)

    print("#" + str(t) + " " + str(res))

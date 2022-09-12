from collections import deque
import copy

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

N, M = map(int, input().split())
lab = [list(map(int, input().split())) for _ in range(N)]
res = 0

def bfs():
    q = deque()
    copyLab = copy.deepcopy(lab)
    for i in range(N):
        for j in range(M):
            if copyLab[i][j] == 2:
                q.append((i,j))

    while q:
        (x, y) = q.popleft()
        for i in range(4):
            x_ = x + dx[i]
            y_ = y + dy[i]
            if 0 <= x_ < N and 0 <= y_ < M and copyLab[x_][y_] == 0:
                copyLab[x_][y_] = 2
                q.append((x_, y_))

    cnt = 0
    for i in range(N):
        cnt += copyLab[i].count(0)
        
    global res
    res = max(res, cnt)

def wall(cnt):
    if cnt == 3:
        bfs()
        return

    for i in range(N):
        for j in range(M):
            if lab[i][j] == 0:
                lab[i][j] = 1
                wall(cnt+1)
                lab[i][j] = 0

wall(0)
print(res)

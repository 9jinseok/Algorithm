from collections import deque

N, M = map(int, input().split())
m = [list(map(int,input().split())) for _ in range(N)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(fx, fy, num):
    q = deque()
    q.append([fx, fy])

    groupSize, rainbowCnt = 1, 0
    blocks, rainbows = [[fx, fy]], []

    while q:
        x, y = q.popleft()
        for k in range(4):
            x_ = x + dx[k]
            y_ = y + dy[k]

            if 0 <= x_ < N and 0 <= y_ < N and visited[x_][y_] == 0:
                if m[x_][y_] == num:
                    visited[x_][y_] = 1
                    groupSize += 1
                    blocks.append([x_, y_])
                    q.append([x_, y_])

                if m[x_][y_] == 0:
                    visited[x_][y_] = 1
                    groupSize += 1
                    rainbowCnt += 1
                    rainbows.append([x_, y_])
                    q.append([x_, y_])

    for x, y in rainbows:
        visited[x][y] = 0

    return [groupSize, rainbowCnt, blocks + rainbows]


score = 0
while True:
    visited = [[0] * N for _ in range(N)]
    blockGroups = []
    for i in range(N):
        for j in range(N):
            if 0 < m[i][j] <= M and visited[i][j] == 0:
                visited[i][j] = 1
                info = bfs(i, j, m[i][j])
                if info[0] >= 2:
                    blockGroups.append(info)

    if not blockGroups:
        break
    blockGroups.sort(reverse=True)
    BBG = blockGroups[0][2]

    score += len(BBG) ** 2
    for (x, y) in BBG:
        m[x][y] = -2

    for i in range(N - 2, -1, -1):
        for j in range(N):
            if m[i][j] >= 0:
                ni = i
                for k in range(i, N):
                    if k + 1 == N or m[k + 1][j] != -2:
                        ni = k
                        break
                tmp = m[i][j]
                m[i][j] = -2
                m[ni][j] = tmp

    newM = [[0] * N for _ in range(N)]

    for i in range(N):
        for j in range(N):
            newM[i][j] = m[j][N-1-i]

    m = newM
    for i in range(N - 2, -1, -1):
        for j in range(N):
            if m[i][j] >= 0:
                ni = i
                for k in range(i, N):
                    if k + 1 == N or m[k + 1][j] != -2:
                        ni = k
                        break
                if ni == i:
                    continue
                m[ni][j] = m[i][j]
                m[i][j] = -2

print(score)
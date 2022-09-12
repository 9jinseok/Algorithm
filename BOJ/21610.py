N, M = map(int, input().split())
m = [list(map(int,input().split())) for _ in range(N)]
move = [list(map(int,input().split())) for _ in range(M)]
dx = [0, -1, -1, -1, 0, 1, 1, 1]
dy = [-1, -1, 0, 1, 1, 1, 0, -1]

cloud = [[N-1,0],[N-1,1],[N-2,0],[N-2,1]]

for d, s in move:
    newCloud = []
    for x, y in cloud:
        x_ = x + dx[d-1] * s
        y_ = y + dy[d-1] * s

        while x_ < 0:
            x_ += N
        while y_ < 0:
            y_ += N
        x_ = x_ % N
        y_ = y_ % N

        newCloud.append([x_,y_])

    visited = [[0] * N for _ in range(N)]
    for x, y in newCloud:
        visited[x][y] = 1
        m[x][y] += 1

    for x, y in newCloud:
        for i in range(1, 8, 2):
            x_ = x + dx[i]
            y_ = y + dy[i]

            if 0 <= x_ < N and 0 <= y_ < N and m[x_][y_] > 0:
                m[x][y] += 1

    cloud = []
    for i in range(N):
        for j in range(N):
            if m[i][j] >= 2 and visited[i][j] == 0:
                cloud.append([i, j])
                m[i][j] -= 2

cnt = 0
for i in range(N):
    cnt += sum(m[i])

print(cnt)
N = int(input())
arr = [list(map(int, input().split())) for _ in range(N**2)]
room = [[0] * N for _ in range(N)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

for info in arr:
    studentNum = info[0]
    likes = info[1:]

    retX = 0
    retY = 0
    likeMax = -1
    emptyMax = -1
    for i in range(N):
        for j in range(N):
            likeCnt = 0
            emptyCnt = 0
            if room[i][j] == 0:
                for k in range(4):
                    x = i + dx[k]
                    y = j + dy[k]
                    if 0 <= x < N and 0 <= y < N:
                        if room[x][y] == 0:
                            emptyCnt += 1
                        if room[x][y] in likes:
                            likeCnt += 1
                if likeMax < likeCnt:
                    likeMax = likeCnt
                    emptyMax = emptyCnt
                    retX, retY = i, j
                elif likeMax == likeCnt and emptyMax < emptyCnt:
                    emptyMax = emptyCnt
                    retX, retY = i, j

    room[retX][retY] = studentNum

res = 0
for i in range(N):
    for j in range(N):
        likes = []
        for a in arr:
            if a[0] == room[i][j]:
                likes = a[1:]
        cnt = 0
        for k in range(4):
            x = i + dx[k]
            y = j + dy[k]
            if 0 <= x < N and 0 <= y < N:
                if room[x][y] in likes:
                    cnt += 1
        if cnt != 0:
            res += 10 ** (cnt - 1)

print(res)
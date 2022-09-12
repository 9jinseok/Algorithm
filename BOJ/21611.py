N, M = map(int, input().split())
m = [list(map(int,input().split())) for _ in range(N)]
spellList = [list(map(int,input().split())) for _ in range(M)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
dx_ = [0, 1, 0, -1]
dy_ = [-1, 0, 1, 0]
one, two, three = 0, 0, 0

posDict = dict()
pos = [(N//2,N//2)]

x, y = N//2, N//2
direction ,amount, count = 0, 1, 0
change = False
for i in range(1, N ** 2):
    x += dx_[direction]
    y += dy_[direction]
    pos.append((x,y))
    count += 1
    if count == amount:
        direction = (direction + 1) % 4
        count = 0
        if change:
            amount += 1
            change = False
        else:
            change = True

def blizzard(d, s):
    global m
    for i in range(1, s+1):
        x = N//2 + dx[d-1] * i
        y = N//2 + dy[d-1] * i
        if x < 0 or x >= N or y < 0 or y >= N:
            break
        m[x][y] = 0

    chk = True
    while chk:
        gravity()
        chk = bomb()

def bomb():
    global one, two, three, m
    chk = False

    prev = 0
    cnt = 0
    for i in range(1, N ** 2):
        x, y = pos[i]
        if m[x][y] == 0:
            if cnt >= 4:
                if prev == 1:
                    one += cnt
                elif prev == 2:
                    two += cnt
                elif prev == 3:
                    three += cnt
                chk = True
                for j in range(cnt):
                    x, y = pos[i - j - 1]
                    m[x][y] = 0
            cnt = 0
            break
        if prev == m[x][y]:
            cnt += 1
        else:
            if cnt >= 4:
                if prev == 1:
                    one += cnt
                elif prev == 2:
                    two += cnt
                elif prev == 3:
                    three += cnt
                chk = True
                for j in range(cnt):
                    x, y = pos[i - j - 1]
                    m[x][y] = 0
            prev = m[x][y]
            cnt = 1
    if cnt >= 4:
        if prev == 1:
            one += cnt
        elif prev == 2:
            two += cnt
        elif prev == 3:
            three += cnt
        chk = True
        for i in range(cnt):
            x, y = pos[N ** 2 - i - 1]
            m[x][y] = 0
    return chk

def gravity():
    global m
    newList = [0]
    for i in range(1, N ** 2):
        x, y = pos[i]
        if m[x][y] != 0:
            newList.append(m[x][y])

    m = [[0] * N for _ in range(N)]
    for i in range(len(newList)):
        x, y = pos[i]
        m[x][y] = newList[i]

def change():
    global m
    newList = [0]
    firstX, firstY = pos[1]
    prev = m[firstX][firstY]
    if prev == 0:
        return
    cnt = 1
    for i in range(2, N ** 2):
        x, y = pos[i]
        if m[x][y] == 0:
            newList.append(cnt)
            newList.append(prev)
            break
        if prev == m[x][y]:
            cnt += 1
        else:
            newList.append(cnt)
            newList.append(prev)
            prev = m[x][y]
            cnt = 1

    m = [[0] * N for _ in range(N)]
    for i in range(len(newList)):
        if i >= N ** 2:
            break
        x, y = pos[i]
        m[x][y] = newList[i]

for i in range(len(spellList)):
    blizzard(spellList[i][0], spellList[i][1])
    if i == len(spellList) - 1:
        break
    change()

print(one + two * 2 + three * 3)
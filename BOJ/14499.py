N, M, x, y, K = map(int, input().split())
m = [list(map(int,input().split())) for _ in range(N)]
move = list(map(int,input().split()))
dice = [0, 0, 0, 0, 0, 0]

def roll(direction):
    global dice
    a,b,c,d,e,f = dice
    if direction == 1:
        dice = [b, f, a, d, e, c]
    elif direction == 2:
        dice = [c, a, f, d, e, b]
    elif direction == 3:
        dice = [e, b, c, a, f, d]
    elif direction == 4:
        dice = [d, b, c, f, a, e]

for g in move:
    if g == 1:
        if y == M - 1:
            continue
        y += 1

    elif g == 2:
        if y == 0:
            continue
        y -= 1

    elif g == 3:
        if x == 0:
            continue
        x -= 1

    elif g == 4:
        if x == N - 1:
            continue
        x += 1

    roll(g)
    if m[x][y] == 0:
        m[x][y] = dice[-1]
    else:
        dice[-1] = m[x][y]
        m[x][y] = 0
    print(dice[0])
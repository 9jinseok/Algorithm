import sys
import copy

dx = [-1,0,1,0]
dy = [0,-1,0,1]
maxSafety = 0

def bfs():
    copyS = copy.deepcopy(s)
    q = []
    for i in range(n):
        for j in range(m):
            if copyS[i][j] == 2:
                q.append([i,j])
    while q:
        x, y = q[0][0], q[0][1]
        del q[0]
        for i in range(4):
            x_ = x + dx[i]
            y_ = y + dy[i]
            if 0 <= x_ < n and 0 <= y_ < m and copyS[x_][y_] == 0:
                copyS[x_][y_] = 2
                q.append([x_,y_])
    
    res = 0
    for i in range(n):
        for j in range(m):
            if copyS[i][j] == 0:
                res += 1
    
    global maxSafety
    maxSafety = max(maxSafety,res)

def wall(cnt):
    if cnt == 3:
        bfs()
        return
    for i in range(n):
        for j in range(m):
            if s[i][j] == 0:
                s[i][j] = 1
                wall(cnt+1)
                s[i][j] = 0

n, m = map(int,sys.stdin.readline().split())

s = [list(map(int,sys.stdin.readline().split())) for _ in range(n)]

wall(0)
print(maxSafety)
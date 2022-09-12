import sys

n = int(sys.stdin.readline())
s = [list(sys.stdin.readline().rstrip()) for _ in range(n)]

dx = [-1,0,1,0]
dy = [0,1,0,-1]
cnt = 0
res = []

def dfs(x,y):
    global cnt
    cnt += 1
    s[x][y] = '0'
    for i in range(4):
        x_ = x + dx[i]
        y_ = y + dy[i]
        if 0<=x_<n and 0<=y_<n and s[x_][y_] == '1':
            dfs(x_,y_)

for i in range(n):
    for j in range(n):
        if s[i][j] == '1':
            cnt = 0
            dfs(i,j)
            res.append(cnt)

print(len(res))
res.sort()
for i in res:
    print(i)
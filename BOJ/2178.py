import sys

n, m = map(int,sys.stdin.readline().split())
s = [list(sys.stdin.readline().rstrip()) for _ in range(n)]

dx = [0,0,1,-1]
dy = [1,-1,0,0]
q = [[0,0]]
s[0][0] = 1

while len(q) > 0 :
    x = q[0][0]
    y = q[0][1]
    del q[0]
    for i in range(4):
        x_ = x + dx[i]
        y_ = y + dy[i]
        if 0<=x_<n and 0<=y_<m and s[x_][y_] == '1':
            q.append([x_,y_])
            s[x_][y_] = s[x][y] + 1

print(s[n-1][m-1])
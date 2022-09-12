from collections import deque

def dfs(v):
    print(v,end=' ')
    visited[v] = 1
    for i in range(1, N+1):
        if visited[i] == 0 and graph[v][i] == 1:
            dfs(i)

def bfs(v):
    q = deque()
    q.append(v)
    visited[v] = 0
    while q:
        v = q.popleft()
        print(v, end=' ')
        for i in range(1,N+1):
            if visited[i] == 1 and graph[v][i] == 1:
                q.append(i)
                visited[i] = 0

N, M, V = map(int, input().split())

graph = [[0]*(N+1) for _ in range(N+1)]

for i in range(M):
    p, q = map(int, input().split())
    graph[p][q] = graph[q][p] = 1

visited = [0] * (N+1)

dfs(V)
print()
bfs(V)
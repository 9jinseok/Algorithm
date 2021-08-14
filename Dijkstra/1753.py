import sys
import heapq

inf = 999999

V, E = map(int,sys.stdin.readline().split())
start = int(sys.stdin.readline())

edgeList = [[] for _ in range(V+1)]
distance = [inf] * (V+1)

for _ in range(E):
    u, v, w = map(int,sys.stdin.readline().split())
    edgeList[u].append((v,w))

q = []
heapq.heappush(q,(0,start))
distance[start] = 0
while q:
    w, u = heapq.heappop(q)
    if w > distance[u]:
        continue
    for e in edgeList[u]:
        cost = e[1] + w
        if cost < distance[e[0]]:
            distance[e[0]] = cost
            heapq.heappush(q,(cost,e[0]))

for i in distance[1:]:
    print(i if i != inf else "INF")
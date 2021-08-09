import heapq
import sys

N = int(sys.stdin.readline())
arr = []

for i in range(N):
    heapq.heappush(arr,int(sys.stdin.readline()))

if N == 1:
    print(0)
else:
    ans = 0
    while len(arr) > 1:
        tmp1 = heapq.heappop(arr)
        tmp2 = heapq.heappop(arr)
        ans += tmp1+tmp2
        heapq.heappush(arr,tmp1+tmp2)
    print(ans)

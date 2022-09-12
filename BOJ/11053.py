import sys

N = int(sys.stdin.readline())

A = list(map(int,sys.stdin.readline().split()))
A.insert(0,0)
dp = [0]

for i in range(1,N+1):
    prev = 0
    for j in range(i):
        if A[j] < A[i]:
            prev = max(prev, dp[j])
    dp.append(prev + 1)

print(max(dp))
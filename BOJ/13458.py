N = int(input())
A = list(map(int,input().split()))
B, C = map(int, input().split())

res = 0

for a in A:
    res += 1
    if a - B <= 0:
        continue
    res += (a - B) // C
    if (a - B) % C != 0:
        res += 1

print(res)
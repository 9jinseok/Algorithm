n = int(input())
arr = []
for i in range(n):
    arr.append(int(input()))

arr.sort(reverse=True)

m = 0
for i in range(n):
    m = max(m,(i+1) * arr[i])

print(m)

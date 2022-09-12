import sys

N = int(sys.stdin.readline())

arr = list(map(int,sys.stdin.readline().split()))

arr.sort()

ansP = p = 0
ansQ = q = len(arr) - 1

ans = arr[p] + arr[q]
while p < q:
    tmp = arr[p] + arr[q]
    if abs(ans) > abs(tmp):
        ans = tmp
        ansP = p
        ansQ = q
        if ans == 0:
            break
    if tmp < 0:
        p += 1
    elif tmp > 0:
        q -= 1

print(arr[ansP],arr[ansQ])
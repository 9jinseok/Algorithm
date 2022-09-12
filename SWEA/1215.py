import sys

sys.stdin = open("input.txt", "r", encoding="UTF-8")

for _ in range(10):
    n = int(input())
    arr = []
    for i in range(8):
        arr.append(input())
    cnt = 0
    for i in range(8):
        for j in range(9 - n):
            chk = True
            for k in range(n//2):
                if arr[i][j+k] != arr[i][j+n-1-k]:
                    chk = False
            if chk:
                cnt += 1
    for i in range(9 - n):
        for j in range(8):
            chk = True
            for k in range(n//2):
                if arr[i+k][j] != arr[i+n-1-k][j]:
                    chk = False
            if chk:
                cnt += 1

    print("#" + str(_) + " " + str(cnt))

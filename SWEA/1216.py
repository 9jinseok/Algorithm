import sys

sys.stdin = open("input.txt", "r", encoding="UTF-8")

for _ in range(10):
    t = int(input())
    arr = []
    for i in range(100):
        arr.append(input())

    ans = 0
    end = False
    for n in range(100, 0, -1):
        for i in range(100):
            for j in range(101 - n):
                chk = True
                for k in range(n//2):
                    if arr[i][j+k] != arr[i][j+n-1-k]:
                        chk = False
                if chk:
                    print("#" + str(t) + " " + str(n))
                    end = True
                    break
            if end:
                break
        if end:
            break
        for i in range(101 - n):
            for j in range(100):
                chk = True
                for k in range(n//2):
                    if arr[i+k][j] != arr[i+n-1-k][j]:
                        chk = False
                if chk:
                    print("#" + str(t) + " " + str(n))
                    end = True
                    break
            if end:
                break
        if end:
            break

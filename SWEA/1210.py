import sys

sys.stdin = open("input.txt", "r")

T = 10

for test_case in range(1, T + 1):
    n = int(input())
    arr = []
    for i in range(100):
        arr.append(list(map(int, input().split())))

    y = 0
    for i in range(100):
        if arr[99][i] == 2:
            y = i
            break

    for x in range(99, -1, -1):
        if y > 0 and arr[x][y-1] == 1:
            for i in range(y - 1, -1, -1):
                if arr[x-1][i] == 1:
                    y = i
                    break
        elif y < 99 and arr[x][y+1] == 1:
            for i in range(y + 1, 100):
                if arr[x - 1][i] == 1:
                    y = i
                    break

    print("#" + str(test_case) + " " + str(y))

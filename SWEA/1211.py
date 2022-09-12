import sys

sys.stdin = open("input.txt", "r")

T = 10

for test_case in range(1, T + 1):
    n = int(input())
    arr = []
    for i in range(100):
        arr.append(list(map(int, input().split())))

    ans = 0
    m = 1000000
    for i in range(100):
        if arr[0][i] == 1:
            y = i
            tmp = 0
            for x in range(100):
                if y < 99 and arr[x][y+1] == 1:
                    for j in range(y+1, 100):
                        tmp += 1
                        if arr[x+1][j] == 1:
                            y = j
                            break
                elif y > 0 and arr[x][y-1] == 1:
                    for j in range(y-1, -1, -1):
                        tmp += 1
                        if arr[x+1][j] == 1:
                            y = j
                            break

            if tmp < m:
                m = tmp
                ans = i

    print("#" + str(test_case) + " " + str(ans))

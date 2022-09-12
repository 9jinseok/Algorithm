import sys

sys.stdin = open("input.txt", "r")

T = 10

for test_case in range(1, T + 1):
    n = int(input())
    arr = []
    for _ in range(100):
        arr += list(map(int, input().split()))

    ans = 0
    for i in range(100):
        tmp = 0
        for j in range(100):
            tmp += arr[i*100 + j]
        ans = max(ans, tmp)

    for i in range(100):
        tmp = 0
        for j in range(100):
            tmp += arr[i + j*100]
        ans = max(ans, tmp)

    tmp = 0
    for j in range(100):
        tmp += arr[j + j*100]
    ans = max(ans, tmp)

    tmp = 0
    for j in range(1, 101):
        tmp += arr[j * 100 - j]
    ans = max(ans, tmp)

    print("#" + str(test_case) + " " + str(ans))

import sys

sys.stdin = open("input.txt", "r")

T = 10

for test_case in range(1, T + 1):
    n = int(input())
    arr = list(map(int, input().split()))
    ans = 0

    for i in range(2, n-2):
        a = arr[i] - arr[i - 2]
        b = arr[i] - arr[i - 1]
        c = arr[i] - arr[i + 1]
        d = arr[i] - arr[i + 2]
        if a > 0 and b > 0 and c > 0 and d > 0:
            ans += min(a, b, c, d)
            i += 2

    print("#" + str(test_case) + " " + str(ans))
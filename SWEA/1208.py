import sys

sys.stdin = open("input.txt", "r")

T = 10

for test_case in range(1, T + 1):
    n = int(input())
    arr = list(map(int, input().split()))
    for i in range(n):
        arr.sort()
        arr[0] += 1
        arr[-1] -= 1

    print("#" + str(test_case) + " " + str(max(arr) - min(arr)))

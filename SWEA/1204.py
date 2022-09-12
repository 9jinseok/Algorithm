import sys

sys.stdin = open("input.txt", "r")

T = int(input())

for test_case in range(1, T + 1):
    t = int(input())
    arr = [0 for _ in range(0, 101)]
    score = list(map(int,input().split()))
    for i in score:
        arr[i] += 1

    ans = max = 0
    for i in range(0,101):
        if max <= arr[i]:
            ans = i
            max = arr[i]
    
    print("#"+str(t)+" "+str(ans))

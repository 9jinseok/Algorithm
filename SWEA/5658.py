import sys

sys.stdin = open("input.txt", "r", encoding="UTF-8")

T = int(input())
for t in range(1, T+1):
    N, K = map(int,input().split())
    s = input()
    arr = []
    for c in s:
        arr.append(c)

    nums = []
    n = N//4
    for i in range(n):
        tmp = [arr[-1]]
        for j in range(N - 1):
            tmp.append(arr[j])
        arr = tmp

        for j in range(4):
            num = ''
            for c in arr[j*n:j*n+n]:
                num += c
            num = int('0x'+num, 16)
            if num not in nums:
                nums.append(num)
    nums.sort(reverse=True)
    print("#"+ str(t) + " " + str(nums[K-1]))

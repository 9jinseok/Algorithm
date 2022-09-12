from itertools import permutations

N = int(input())
nums = list(map(int,input().split()))
op_cnt = list(map(int,input().split()))
ops = ['+','-','*','/']
op = []

for i in range(4):
    for j in range(op_cnt[i]):
        op.append(ops[i])

M = -1e9
m = 1e9
for case in permutations(op,N-1):
    res = nums[0]
    for i in range(len(case)):
        if case[i] == '+':
            res += nums[i+1]
        elif case[i] == '-':
            res -= nums[i+1]
        elif case[i] == '*':
            res *= nums[i+1]
        elif case[i] == '/':
            res = int(res/nums[i+1])

    M = max(M, res)
    m = min(m, res)

print(M)
print(m)
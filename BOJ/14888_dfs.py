N = int(input())
nums = list(map(int,input().split()))
op = list(map(int,input().split()))

M = -1e9
m = 1e9

def dfs(depth, total, plus, minus, mult, divide):
    global M, m
    if depth == N:
        M = max(M, total)
        m = min(m, total)
        return

    if plus:
        dfs(depth+1, total + nums[depth],plus-1,minus,mult,divide)
    if minus:
        dfs(depth+1, total - nums[depth],plus,minus-1,mult,divide)
    if mult:
        dfs(depth+1, total * nums[depth],plus,minus,mult-1,divide)
    if divide:
        dfs(depth+1, int(total/nums[depth]),plus,minus,mult,divide-1)

dfs(1, nums[0], op[0], op[1], op[2], op[3])
print(M)
print(m)
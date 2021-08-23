import math

def solution(S):
    cnt = S.count('a')
    if cnt == 0:
        return nCr(len(S)-1,2)
    if cnt % 3 != 0:
        return 0
    cnt = int(cnt/3)
    a = -1
    for i in range(cnt):
        a = S[a+1:].index('a') + a+1
    b = S[a+1:].index('a') + a+1
    c = b
    for i in range(cnt-1):
        c = S[c+1:].index('a') + c+1
    d = S[c+1:].index('a') + c+1
    return (b-a) * (d-c)

def nCr(n,r):
    f = math.factorial
    return int(f(n) / f(r) / f(n-r))

print(solution("bbbbb"))
from itertools import combinations

N = int(input())
S = [list(map(int,input().split())) for _ in range(N)]

member = [i for i in range(N)]
teams = [t for t in list(combinations(member, N//2))]

m = 999999
for i in range(len(teams)//2):
    t = teams[i]
    stat = 0
    for p in t:
        for j in range(len(t)):
            stat += S[p][t[j]]

    t = teams[-i-1]
    for p in t:
        for j in range(len(t)):
            stat -= S[p][t[j]]

    m = min(m, abs(stat))

print(m)
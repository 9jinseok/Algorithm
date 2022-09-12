from itertools import combinations

N, M = map(int,input().split())
cityMap = [list(map(int, input().split())) for _ in range(N)]
house = []
chicken = []

for i in range(N):
    for j in range(N):
        if cityMap[i][j] == 1:
            house.append((i,j))
        elif cityMap[i][j] == 2:
            chicken.append((i,j))

res = 99999
for chosenChicken in combinations(chicken, M):
    chickenDist = 0
    for x, y in house:
        d = 999
        for x_, y_ in chosenChicken:
            d = min(d, abs(x - x_) + abs(y - y_))
        chickenDist += d
    res = min(res, chickenDist)

print(res)
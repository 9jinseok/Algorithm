def solution(time, gold, upgrade):
    res = []

    for i in range(len(upgrade) - 1, -1, -1):
        money = 0
        t = 0
        chk = True
        for j in range(1, i+1):
            while time >= t + upgrade[j-1][1] and money < upgrade[j][0]:
                t += upgrade[j-1][1]
                money += gold
            if money >= upgrade[j][0]:
                money -= upgrade[j][0]
            
            else:
                chk = False
                break
        if chk:
            while time >= t + upgrade[i][1]:
                t += upgrade[i][1]
                money += gold
            res.append(money)
        else:
            res.append(0)
    return max(res)

print(solution(49,200,[[0, 5], [1500, 3], [1501, 1]]))
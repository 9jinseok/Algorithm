def solution(alp, cop, problems):
    cost = 0
    posP = [[0, 0, 1, 0, 1], [0, 0, 0, 1, 1]]

    while True:
        print(alp, cop)
        newProblems = []
        for p in problems:
            if alp >= p[0] and cop >= p[1]:
                posP.append(p)
            else:
                newProblems.append(p)
        problems = newProblems[:]
        if not problems:
            break

        idx = -1
        minP = 1e9
        for i in range(len(problems)):
            if minP > problems[i][0] + problems[i][1]:
                minP = problems[i][0] + problems[i][1]
                idx = i

        nextAlp = problems[idx][0]
        nextCop = problems[idx][1]

        if cop >= nextCop:
            print('alp만 신경쓰면 될 때')
            reqAlp = nextAlp - alp

            idx = -1
            tmpCost = 1e9
            for i in range(len(posP)):
                if posP[i][2] == 0:
                    continue
                tmpN = reqAlp // posP[i][2]
                if reqAlp % posP[i][2] != 0:
                    tmpN += 1

                if tmpCost > posP[i][4] * tmpN:
                    tmpCost = posP[i][4] * tmpN
                    idx = i

            alp += posP[idx][2]
            cop += posP[idx][3]
            cost += posP[idx][4]
        elif alp >= nextAlp:
            print('cop만')
            reqCop = nextCop - cop

            idx = -1
            tmpCost = 1e9
            for i in range(len(posP)):
                if posP[i][3] == 0:
                    continue
                tmpN = reqCop // posP[i][3]
                if reqCop % posP[i][3] != 0:
                    tmpN += 1

                if tmpCost > posP[i][4] * tmpN:
                    tmpCost = posP[i][4] * tmpN
                    idx = i

            alp += posP[idx][2]
            cop += posP[idx][3]
            cost += posP[idx][4]
        else:
            print('둘다신경쓸때')
            reqAlp = nextAlp - alp
            reqCop = nextCop - cop

            idx = -1
            tmpCost = 1e9
            for i in range(len(posP)):
                if posP[i][3] == 0 or posP[i][2] == 0:
                    continue
                tmpN1 = reqAlp // posP[i][2]
                if reqAlp % posP[i][2] != 0:
                    tmpN1 += 1

                tmpN2 = reqCop // posP[i][3]
                if reqCop % posP[i][3] != 0:
                    tmpN2 += 1

                if tmpCost > posP[i][4] * max(tmpN1, tmpN2):
                    tmpCost = posP[i][4] * max(tmpN1, tmpN2)
                    idx = i

            alp += posP[idx][2]
            cop += posP[idx][3]
            cost += posP[idx][4]

    return cost

print(solution(10,10,[[10,15,2,1,2],[20,20,3,3,4]]))
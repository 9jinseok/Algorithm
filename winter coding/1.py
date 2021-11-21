def solution(character, monsters):
    hp, a, d = map(int,character.split(" "))

    res = []
    for m in monsters:
        sec = 0
        mList = m.split(" ")
        name = mList[0]
        exp, Mhp, Ma, Md = map(int,mList[1:])
        if Ma - d >= hp and a - Md < Mhp:
            res.append([name,0,0])
            continue
        
        if a - Md <= 0:
            res.append([name,0,0])
            continue

        while Mhp > 0:
            Mhp -= a - Md
            sec += 1
        
        res.append([name,exp/sec,exp])
    
    expPsec = 0.0
    exp = 0.0
    ans = ""
    for r in res:
        if expPsec < r[1]:
            ans = r[0]
            expPsec = r[1]
            exp = r[2]
        elif expPsec == r[1] and exp < r[2]:
            ans = r[0]
            expPsec = r[1]
            exp = r[2]
    print(res)
    return ans

print(solution("10 5 2",["Knight 3 10 10 3","Wizard 5 10 15 1","Bener 1 1 15 1","Begi 2 1 15 1"]))
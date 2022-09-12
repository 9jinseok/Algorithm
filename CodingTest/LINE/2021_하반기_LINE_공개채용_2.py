def solution(research, n, k):
    alpha = []
    for str in research:
         for c in str:
            if not c in alpha:
                alpha.append(c)
    alpha.sort()

    cnt = [0 for _ in range(len(alpha))]
    for i in range(len(alpha)):
        a = alpha[i]
        for j in range(len(research) - n + 1):
            tot = 0
            chk = True
            for l in range(j,j+n):
                if research[l].count(a) < k:
                    chk = False
                    break
                tot += research[l].count(a)
                
            if tot < 2 * n * k:
                chk = False
            if chk:
                cnt[i] += 1
    
    max = 0
    maxIdx = -1
    for i in range(len(cnt)):
        if cnt[i] > max:
            maxIdx = i
            max = cnt[i]
    
    if max == 0:
        return "None"
    return alpha[maxIdx]

print(solution(["yxxy","xxyyy","yz"],2,1))
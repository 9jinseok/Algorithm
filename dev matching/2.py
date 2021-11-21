def solution(leave, day, holidays):
    sat = sun = 0
    if day == "MON":
        sat = 6
        sun = 7
    elif day == "TUE":
        sat = 5
        sun = 6
    elif day == "WED":
        sat = 4
        sun = 5
    elif day == "THU":
        sat = 3
        sun = 4
    elif day == "FRI":
        sat = 2
        sun = 3
    elif day == "SAT":
        sat = 1
        sun = 2
    elif day == "SUN":
        sat = 7
        sun = 1
    
    while sat <= 30:
        if sat not in holidays:
            holidays.append(sat)
        sat += 7
    while sun <= 30:
        if sun not in holidays:
            holidays.append(sun)
        sun += 7
    holidays.sort()
    
    if len(holidays) + leave >= 30:
        return 30
    
    g = []
    tmp = [holidays[0]]
    for i in range(1, len(holidays)):
        if holidays[i-1] == holidays[i] - 1:
            tmp.append(holidays[i])
        else:
            g.append(tmp)
            tmp = [holidays[i]]
    g.append(tmp)

    if leave == 0:
        res = 0
        for i in g:
            res = max(res,len(i))
        return res
    
    k = []
    for i in range (1, len(g)):
        k.append(g[i][0] - g[i-1][-1] - 1)
    
    res = 0
    for i in range(len(k)):
        if k[i] > leave:
            continue
        tmp = k[i]
        cnt = len(g[i]) + len(g[i+1])
        idx = i + 1
        while idx < len(k):
            if tmp + k[idx] > leave:
                break
            tmp += k[idx]
            cnt += len(g[idx+1])
            idx += 1
        res = max(res,cnt+leave)
    
    return res
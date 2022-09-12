#못풀었음
def solution(records, k, date):
    answer = []
    end = list(map(int,date.split("-")))
    
    start = end.copy()
    start[2] -= (k-1)

    while start[2] < 1:
        start[2] += 30
        start[1] -= 1
    if start[1] < 1:
        start[1] += 12
        start[0] -= 1
    
    idx = 0

    while True:
        time = list(map(int,records[idx].split()[0].split("-")))
        if beforeOrSame(start,time):
            break
        idx += 1

    up = []
    pids = dict()
    
    for i in range(idx, len(records)):
        tmp = records[i].split()
        u = int(tmp[1][3:])
        p = int(tmp[2][3:])
        time = list(map(int,tmp[0].split("-")))
        if not beforeOrSame(time,end):
            break
        up.append((u,p))
        if not p in pids:
            pids[p] = 0
    for key in pids:
        uids = []
        rebuyUids = set()
        cnt = 0
        for x in up:
            if x[1] == key:
                cnt += 1
                if not x[0] in uids:
                    uids.append(x[0])
                else:
                    rebuyUids.add(x[0])
        pids[key] = len(rebuyUids)/len(uids) + cnt * 0.00001
    res = sorted(pids.items(), key=lambda x:x[1], reverse=True)
    for x in res:
        answer.append("pid"+str(x[0]))
    return answer

def beforeOrSame(date1, date2):
    if date1[0] < date2[0]:
        return True
    elif date1[0] > date2[0]:
        return False
    else:
        if date1[1] < date2[1]:
            return True
        elif date1[1] > date2[1]:
            return False
        else:
            if date1[2] <= date2[2]:
                return True
            else:
                return False
                
print(solution(["2020-02-02 uid1 pid1", "2020-02-26 uid1 pid1", "2020-02-26 uid2 pid1", "2020-02-27 uid3 pid2", "2020-02-28 uid4 pid2", "2020-02-29 uid3 pid3", "2020-03-01 uid4 pid3", "2020-03-03 uid1 pid1", "2020-03-04 uid2 pid1", "2020-03-05 uid3 pid2", "2020-03-05 uid3 pid3", "2020-03-05 uid3 pid3", "2020-03-06 uid1 pid4"],10,"2020-03-05"))
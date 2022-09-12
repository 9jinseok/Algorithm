def solution(n, t, m, timetable):
    timetable = [int(i.replace(':','')) for i in timetable]
    timetable.sort()

    bus = [900]
    for i in range(1,n):
        tmp = bus[i-1] + t
        if tmp % 100 >= 60:
            tmp -= 60
            tmp += 100
        bus.append(tmp)

    idx = 0
    full = True
    for i in bus:
        full = True
        for _ in range(m):
            if idx >= len(timetable) or timetable[idx] > i:
                full = False
                break
            else:
                idx += 1

    ans = bus[-1]
    if full:
        ans = timetable[idx-1] - 1
        if ans % 100 == 99:
            ans -= 40

    if ans >= 1000:
        answer = str(ans)
        answer = answer[:2] + ":" + answer[2:]
    elif ans >= 100:
        answer = str(ans)
        answer = "0" + answer[0] + ":" + answer[1:]
    elif ans >= 10:
        answer = "00:" + str(ans)
    else:
        answer = "00:0" + str(ans)
    return answer

print(solution(2,10,2,["09:10", "09:09", "08:00"]))
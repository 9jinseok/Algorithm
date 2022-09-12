def solution(S, T):
    now = S.replace(':','')
    T = T.replace(':','')
    cnt = 0

    while True:
        if count(now) <= 2:
            cnt += 1
        if now == T:
            break
        next = int(now) + 1
        if next % 100 == 60:
            next -= 60
            next += 100
            if next % 10000 == 6000:
                next -= 6000
                next += 10000
        now = str(next).rjust(6,'0')

    return cnt

def count(T):
    return len(''.join(set(T)))

print(solution("00:00:00","23:59:59"))
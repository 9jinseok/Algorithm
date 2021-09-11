def solution(n):
    arr = []

    ans = [0 for _ in range(n)]

    d = 2
    while d <= n:
        if n % d == 0:
            arr.append(d)
            n = n / d
        else:
            d = d + 1

    return 0
    
print(solution(12))
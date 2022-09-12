def solution(n, clockwise):
    answer = [[0]*n for _ in range(n)]
    if n % 2 == 0:
        k = 1
        m = n*n / 4

        for i in range(n/2):
            x = 0
            y = 0
            answer[x][y] = k

    return answer
    
print(solution(5, True))
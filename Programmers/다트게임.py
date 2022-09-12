def solution(dartResult):
    answer = 0
    prev = 0
    n = 0
    for c in dartResult:
        if '0'<= c and '9' >= c:
            answer += n
            prev = n
            if c == '0' and n == 1:
                answer -= 1
                n = 10
            else:
                n = int(c)
        elif c == 'D':
            n = pow(n,2)
        elif c == 'T':
            n = pow(n,3)
        elif c == '*':
            n *= 2
            answer += prev
        elif c == '#':
            n = -n
        
    return answer + n

print(solution("1D2S3T*"))
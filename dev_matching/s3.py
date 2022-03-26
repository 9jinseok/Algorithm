def solution(wave1, wave2):
    answer = float("inf")
    n, m = len(wave1), len(wave2)

    for i in range(n):
        w = sh(wave1,i)
        for j in range(m):
            w2 = sh(wave2,j)
            lcm = findlcm(n, m)
            w1 = w * (lcm//n)
            w2 *= lcm//m
            for i in range(lcm):
                w1[i] += w2[i]

            w1 = re(w1,lcm)
            if len(w1) == 1:
                return 0
            sum = 0
            for i in w1:
                sum += i**2
            answer = min(answer,sum)
            
    return answer

def sh(l, n):
    return l[-n:] + l[:-n]

def findlcm(x, y):
    tmp = x * y
    while y:
        x, y = y, x%y
    return tmp // x

def getMyDivisor(n):

    divisorsList = []

    for i in range(2, int(n**(1/2)) + 1):
        if (n % i == 0):
            divisorsList.append(i) 
            if ( (i**2) != n) : 
                divisorsList.append(n // i)

    divisorsList.sort()
    
    return divisorsList

def re(l,n):
    if len(set(l)) == 1:
        return [0]
    dList = getMyDivisor(n)
    for i in dList:
        if l == l[:i] * (n//i):
            return l[:i]
    return l

print(solution([2,0,1,1,1,0], [0,0,-1]))
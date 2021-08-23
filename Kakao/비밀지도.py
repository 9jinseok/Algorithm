def solution(n, arr1, arr2):
    answer = []

    for i in range(n):
        a = arr1[i]
        b = arr2[i]
        p = pow(2,n-1)
        l = ""
        while p >= 1:
            if a < p and b < p:
                l += " "
            else:
                l += "#"
            a %= p
            b %= p
            p /= 2
        answer.append(l)

    return answer
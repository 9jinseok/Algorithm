def solution(str1, str2):
    a = []
    b = []
    for i in range(len(str1)-1):
        tmp = str1[i:i+2].upper()
        if tmp.isalpha():
            a.append(tmp)
    for i in range(len(str2)-1):
        tmp = str2[i:i+2].upper()
        if tmp.isalpha():
            b.append(tmp)

    if len(a) == 0 and len(b) == 0:
        return 65536

    x = 0
    for i in a:
        if i in b:
            x += 1
            b.pop(b.index(i))
    x /= len(a) + len(b)
    x = int(x*65536)
    return x

print(solution("E=M*C^2","e=m*c^2"))
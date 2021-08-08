T = int(input())

a = 0 ; b = 0 ; c = 0

if(T % 10 != 0):
    print(-1)
else:
    a = T // 300
    T = T % 300
    b = T // 60
    T = T % 60
    c = T // 10
    print(str(a)+" "+str(b)+" "+str(c))
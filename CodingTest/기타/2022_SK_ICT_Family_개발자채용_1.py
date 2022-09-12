def solution(money, costs):
    answer = 0
    a = [1,5,10,50,100,500]
    c = []
    for i in range(6):
        c.append([costs[i]/a[i],a[i],costs[i]])
    c.sort()
    print(c)
    for i in c:
        while money >= i[1]:
            answer += i[2]
            money -= i[1]
    return answer

print(solution(4578,[1, 4, 99, 35, 50, 1000]))
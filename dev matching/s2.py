def solution(names, homes, grades):
    n = len(names)
    for i in range(n):
        grades[i] = int(grades[i])
        homes[i] = homes[i][0]**2 + homes[i][1]**2
    
    ans = []
    for i in range(n):
        ans.append([i,names[i],homes[i],grades[i]])

    ans.sort(key=lambda ans: ans[1])
    ans.sort(key=lambda ans: ans[2], reverse=True)
    ans.sort(key=lambda ans: ans[3], reverse=True)

    for i in range(n):
        names[ans[i][0]] = i+1

    return names


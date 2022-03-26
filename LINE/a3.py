def solution(num_teams, remote_tasks, office_tasks, employees):
    emp = []
    team = [0 for _ in range(num_teams)]
    l = len(employees)
    for i in range(l):
        emp.append(i+1)

    for i in range(l):
        tasks = employees[i].split()
        for t in tasks:
            if t in office_tasks:
                emp[i] = 0
                team[int(tasks[0]) - 1] += 1
                break
    for i in range(num_teams):
        if team[i] == 0:
            for j in range(l):
                if int(employees[j].split()[0]) == i + 1:
                    emp[j] = 0
                    team[i] = 1
                    break
    ans = []
    for i in emp:
        if i != 0:
            ans.append(i)
    return ans

print(solution(3,["development","marketing","hometask"],["recruitment","education","officetask"],["1 development hometask","1 recruitment marketing","2 hometask","2 development marketing hometask","3 marketing","3 officetask","3 development"]))
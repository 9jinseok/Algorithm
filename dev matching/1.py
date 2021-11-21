def solution(registered_list, new_id):
    idx = -1
    for i in range(len(new_id)):
        if new_id[i] >= '0' and new_id[i] <= '9':
            idx = i
            break
    S = new_id
    N = 0
    if idx != -1:
        N = int(new_id[idx:])
        S = new_id[:idx]
    
    new_list = []
    for i in registered_list:
        if S in i:
            if i == S:
                new_list.append(0)
            else:
                new_list.append(int(i[len(S):]))

    new_list.sort()
    if N in new_list:
        idx = new_list.index(N)
    else:
        return new_id
    
    if new_list[-1] - N == len(new_list) - 1 - idx:
        N = new_list[-1] + 1
    else:
        while N == new_list[idx]:
            N += 1
            idx += 1
            
    return S+str(N)

print(solution(["bird99", "bird98", "bird101", "gotoxy"], "bird98"))
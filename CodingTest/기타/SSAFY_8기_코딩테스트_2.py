T = int(input())

for t in range(T):
    N = int(input())
    arr = []
    for i in range(N):
        arr.append(list(map(int, input().split())))

    visited = [False] * N

    ans = 0
    while True:
        oldVisited = visited[:]
        ans += 1
        for i in range(N):
            if visited[i]:
                continue
            if arr[i][0] == 0:
                visited[i] = True
            else:
                chk = True
                for j in range(arr[i][0]):
                    if not oldVisited[arr[i][j + 1] - 1]:
                        chk = False
                        break
                if chk:
                    visited[i] = True

        if oldVisited == visited:
            print("#" + str(t+1) + " -1")
            break

        chk = True
        for i in range(N):
            if not visited[i]:
                chk = False
                break
        if chk:
            print("#" + str(t+1) + " " + str(ans))
            break
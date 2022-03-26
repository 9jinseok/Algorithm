def solution(abilities, k):
    answer = 0
    l = len(abilities)
    if l % 2 != 0:
        abilities.append(0)
        l += 1
    abilities.sort(reverse = True)
    
    arr = []
    for i in range(0,l,2):
        arr.append(abilities[i:i+2])
    
    dif = []

    for a in arr:
        dif.append(a[0] - a[1])

    print(arr, dif)

    for i in range(k):
        max = 0
        idx = 0
        for j in range(len(dif)):
            if dif[j] > max:
                max = dif[j]
                idx = j
        
        tmp = arr[idx][0]
        arr[idx][0] = arr[idx][1]
        arr[idx][1] = tmp
        dif[idx] = 0

    for a in arr:
        answer += a[1]

    return answer

print(solution([2, 8, 3, 6, 1, 9, 1, 9], 2))
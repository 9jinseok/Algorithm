def solution(arr, brr):
    answer = 0
    a = [arr[0]]
    b = [brr[0]]
    
    for i in range(1,len(arr)):
        a.append(arr[i] + a[i-1])
        b.append(brr[i] + b[i-1])

    while a != b:
        for i in range(len(arr) - 1):
            if a[i] > b[i] or (a[i] < b[i] and a[i+1] > b[i]):
                a[i] = b[i]
                answer += 1
    return answer

print(solution([1, 1, 1, 13], [13, 1, 1, 1]))
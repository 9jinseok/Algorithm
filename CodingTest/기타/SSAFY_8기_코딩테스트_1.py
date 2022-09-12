T = int(input())

for t in range(T):
    N = int(input())
    arr = list(map(int, input().split()))

    ans = 0
    sorted_arr = sorted(arr)

    while True:
        if sorted_arr == arr:
            print("#" + str(t+1) + " " + str(ans))
            break

        newArr = []
        for i in range(0, N, 2):
            if i == N - 1:
                newArr.append(arr[i])
                break
            if arr[i] > arr[i+1]:
                newArr.append(arr[i+1])
                newArr.append(arr[i])
            else:
                newArr.append(arr[i])
                newArr.append(arr[i + 1])

        print(newArr)

        arr = newArr[:]
        newArr = [arr[0]]
        for i in range(1, N, 2):
            if i == N - 1:
                newArr.append(arr[i])
                break
            if arr[i] > arr[i+1]:
                newArr.append(arr[i+1])
                newArr.append(arr[i])
            else:
                newArr.append(arr[i])
                newArr.append(arr[i + 1])
        arr = newArr[:]

        ans += 1

def LIS(arr):
    dp = [0] * len(arr)

    for i in range(1, len(arr)):
        for j in range(i - 1, -1, -1):
            if arr[i] > arr[j]:
                dp[i] = max(dp[i], dp[j] + 1)

    return max(dp) + 1

if __name__ == "__main__":
    print(LIS([7,2,3,8,4,5]))
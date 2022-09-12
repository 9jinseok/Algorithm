def MergeSort(arr, start, end):
    if start < end:
        mid = (start+end) // 2

        MergeSort(arr, start, mid)
        MergeSort(arr, mid + 1, end)
        Merge(arr, start, mid, end)

def Merge(arr, start, mid, end):
    L = arr[start:mid+1]
    R = arr[mid+1:end+1]

    idx = start
    left = right = 0
    ll = len(L)
    lr = len(R)

    while left < ll and right < lr:
        if L[left] <= R[right]:
            arr[idx] = L[left]
            left += 1
        else:
            arr[idx] = R[right]
            right += 1
        idx += 1

    while left < ll:
        arr[idx] = L[left]
        idx += 1
        left += 1
    while right < lr:
        arr[idx] = R[right]
        idx += 1
        right += 1

def main():
    arr = [230, 10, 60, 550, 40, 220, 20]
    MergeSort(arr, 0, len(arr) - 1)
    print(arr)

if __name__ == "__main__":
    main()
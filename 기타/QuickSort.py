def QuickSort(arr, start, end):
    if start >= end:
        return
    pivot = partition(arr, start, end)

    QuickSort(arr, start, pivot - 1)
    QuickSort(arr, pivot + 1, end)

def partition(arr, start, end):
    mid = ( start + end ) // 2
    arr[mid], arr[start] = arr[start], arr[mid]

    pivot = arr[start]

    left = start
    right = end

    while left < right:
        while arr[right] > pivot:
            right -= 1

        while left < right and arr[left] <= pivot:
            left += 1

        arr[right], arr[left] = arr[left], arr[right]

    arr[start] = arr[left]
    arr[left] = pivot

    return left

def main():
    arr = [3, 8, 0, 2, 1, 4]
    QuickSort(arr, 0, len(arr) - 1)
    print(arr)

if __name__ == "__main__":
    main()
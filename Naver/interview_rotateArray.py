def rotate(arr, n):
    n %= len(arr)
    return arr[-n:] + arr[:-n]

if __name__ == "__main__":
    print(rotate([1,2,3,4,5,6],2))
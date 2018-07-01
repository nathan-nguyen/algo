if __name__ == '__main__':
    n = int(input())
    arr = list(map(int, input().split()))
    maxV = max(arr)
    while maxV == max(arr):
        arr.remove(maxV)
    print(max(arr))


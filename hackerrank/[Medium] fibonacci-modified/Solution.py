#!/bin/python3

import sys

def fibonacciModified(t1, t2, n):
    # Complete this function
    if n == 3:
        return t1 + t2 ** 2
    return fibonacciModified(t2, t1 + t2 ** 2, n - 1)

if __name__ == "__main__":
    t1, t2, n = input().strip().split(' ')
    t1, t2, n = [int(t1), int(t2), int(n)]
    result = fibonacciModified(t1, t2, n)
    print(result)


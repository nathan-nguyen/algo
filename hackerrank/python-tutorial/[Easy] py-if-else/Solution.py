#!/bin/python3

N = int(input())

if N % 2 == 1 or (N >= 6 and N <= 20):
	print("Weird")
else:
	print("Not Weird")


#!/usr/bin/env scala

def f(n:Int,arr:List[Int]):List[Int] = arr.filter(x => x < n)

f(25, List(-41, 46, -28, 21, 52, 83, -29, 84, 27, 40)).foreach(println)

#!/usr/bin/env scala

def f(num:Int, arr:List[Int]):List[Int] = arr.flatMap(x => List.fill(num)(x))

f(3, List(1, 2, 3)).foreach(println)


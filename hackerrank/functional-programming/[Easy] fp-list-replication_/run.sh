#!/usr/bin/env scala

def f(num:Int, arr:List[Int]):List[Int] = arr.flatMap(x => List.fill(num)(x))


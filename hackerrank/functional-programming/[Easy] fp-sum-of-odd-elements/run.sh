#!/usr/bin/env scala

def f(arr:List[Int]):Int = arr.filter(_ % 2 != 0).sum

println(f(List(1, 2, 3, 4, 5)))
println(f(List()))

// Expect: 39
println(f(List(11, 25, 18, -1, 26, -20, -19, 23, -24, -8)))


#!/usr/bin/env scala

import scala.collection.mutable.ListBuffer

def f(arr:List[Int]):List[Int] = arr.grouped(2).flatMap(_.tail).toList

f(List(8, 15, 22, 1, 10, 6, 2, 18, 18, 1)).foreach(println)

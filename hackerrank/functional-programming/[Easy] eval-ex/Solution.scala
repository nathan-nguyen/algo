object Solution {

  def f(x: Double, n: Int, result: Double, increase: Double): Double = n match {
    case 11 => result
    case _  => f(x, n + 1, result + increase, increase * x / n)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt

    for (nItr <- 1 to n) {
      val x = stdin.readLine.trim.toDouble
      println(f(x, 1, 0, 1))
    }
  }
}


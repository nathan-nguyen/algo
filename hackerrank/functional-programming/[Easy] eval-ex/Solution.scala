object Solution {

  def f(x: Double): Double = {
    def f(n: Int, result: Double, increase: Double): Double = n match {
      case 11 => result
      case _  => f(n + 1, result + increase, increase * x / n)
    }
    f(1, 0, 1)
  }

  def main(args: Array[String]) {
    val stdIn = scala.io.StdIn
    val n = stdIn.readInt

    (1 to n) foreach(_ => println(f(stdIn.readDouble)))
  }
}



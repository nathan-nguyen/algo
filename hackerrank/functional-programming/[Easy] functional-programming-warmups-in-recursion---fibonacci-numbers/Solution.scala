import scala.language.postfixOps

object Solution extends App {

  val fibonacci: Stream[Int] = 0 #:: fibonacci.scanLeft(1)(_ + _)

  val n = scala.io.StdIn.readInt()
  println((fibonacci take n toList)(n - 1))
}


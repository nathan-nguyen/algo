object Solution extends App {

  def fibonacci(n:Int):Int = n match {
    case 1 => 0
    case 2 => 1
    case x => fibonacci(x - 1) + fibonacci(x - 2)
  }

  println(fibonacci(scala.io.StdIn.readInt()))
}

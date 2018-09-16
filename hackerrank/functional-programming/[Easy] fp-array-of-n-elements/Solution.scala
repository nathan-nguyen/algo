object Solution extends App {
  def f(num:Int) : List[Int] = List.fill(num)(0)

  println(f(scala.io.StdIn.readInt))
}

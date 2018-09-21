object Solution {
  
  def fibonacci(n:Int):Int = {
    def fibonacci(x: Int, y:Int, n:Int):Int = {
      if (n == 0) x
      else fibonacci(y, x + y, n - 1)
    }
    fibonacci(0, 1, n-1)
  }

  def main(args: Array[String]) {
    println(fibonacci(scala.io.StdIn.readInt()))
  }
}

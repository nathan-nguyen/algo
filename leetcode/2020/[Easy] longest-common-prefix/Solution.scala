object Solution {
  def commonPrefix(s: String, u: String): String = {
    def f(i: Int, result: StringBuilder): StringBuilder = {
      if (i < s.length && i < u.length && s(i) == u(i)) f(i + 1, result + s(i)) 
      else result
    }
    f(0, new StringBuilder).toString
  }
  
  def longestCommonPrefix(sArr: Array[String]): String = sArr.size match {
    case 0 => new String
    case _ => {
      def f(i: Int, result: String): String = {
        if (result.length == 0 || i == sArr.length) result
        else f(i + 1, commonPrefix(result, sArr(i)))
      }
      f(0, sArr(0))
    }
  }
}


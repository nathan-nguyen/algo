object Solution {
  def isPalindrome(x: Int): Boolean = {
    if (x == 0) true
    else if (x < 0) false
    else {
      val s = x.toString
      isPalindrome(s, 0, s.length - 1)
    }
  }

  def isPalindrome(x: String, start: Int, end: Int): Boolean = {
    if (start >= end) true
    else x.charAt(start) == x.charAt(end) && isPalindrome(x, start + 1, end - 1)
  }
}

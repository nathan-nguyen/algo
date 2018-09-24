object Solution {
  def numJewelsInStones(j: String, s: String): Int = {
    val mem = Array.ofDim[Boolean](256)
    j.foreach(c => mem(c) = true)
    s.filter(c => mem(c)).size
  }
}


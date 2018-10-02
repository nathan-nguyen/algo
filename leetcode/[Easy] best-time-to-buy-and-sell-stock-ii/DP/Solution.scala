object Solution {
  def maxProfit(p: Array[Int]): Int = {
    if (p.length == 0) return 0
    var hold = -p(0)
    var notBuy = 0
    (1 until p.length) foreach(i => {
        notBuy = Math.max(notBuy, hold + p(i))
        hold = notBuy - p(i)
    })
    notBuy
  }
}


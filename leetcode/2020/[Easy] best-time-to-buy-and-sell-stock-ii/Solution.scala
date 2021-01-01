object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    if (prices.length == 0) return 0
    var min = prices(0)
    var total = 0
    (1 until prices.length) foreach(i => {
      if (min < prices(i)) total += prices(i) - min;
      min = prices(i)
    })
    total
  }
}

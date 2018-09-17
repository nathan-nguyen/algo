import scala.collection.mutable.HashMap

object Solution {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map: HashMap[Int, Int] = HashMap()
    for (i <- 0 until nums.size) {
      if (map.contains(target - nums(i))) return Array(map.getOrElse(target - nums(i), -1), i)
      map += (nums(i) -> i)
    }
    Array()
  }
}

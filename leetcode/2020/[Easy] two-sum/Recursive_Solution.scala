import scala.collection.mutable.HashMap

object Solution {
  def twoSum(index: Int, target: Int, nums:Array[Int], map: HashMap[Int, Int]): Array[Int] = {
    if (map.contains(target - nums(index))) Array(map.getOrElse(target - nums(index), -1), index)
    else {
      map += (nums(index) -> index)
      twoSum(index + 1, target, nums, map)
    }
  }

  def twoSum(nums: Array[Int], target: Int): Array[Int] = twoSum(0, target, nums, HashMap())
}

object Solution {
  def maxArea(left: Int, right: Int, height: Array[Int], max:Int): Int = {
    if (left >= right) max
    else if (height(left) <= height(right)) maxArea(left + 1, right, height, Math.max(max, (right - left) * height(left)))
    else maxArea(left, right - 1, height, Math.max(max, (right - left) * height(right)))
  }
                                          
  def maxArea(height: Array[Int]): Int = maxArea(0, height.size - 1, height, 0)
}

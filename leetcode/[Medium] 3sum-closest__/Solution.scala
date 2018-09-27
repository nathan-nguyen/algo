object Solution {
    def threeSumClosest(nums: Array[Int], target: Int): Int = {
        scala.util.Sorting.quickSort(nums)
        var min = nums(0) + nums(1) + nums(2)
        
        def twoSumClosest(i: Int) = {
            var start = i + 1
            var end = nums.length - 1
            while (start < end) {
                var sum = nums(i) + nums(start) + nums(end)
                if (sum <= target) start += 1
                else end -= 1
                if (Math.abs(min - target) > Math.abs(sum - target)) min = sum
            }
        }
        
        (0 to nums.length - 3) foreach(i => twoSumClosest(i))
        min
    }
}


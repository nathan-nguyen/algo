class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k > nums.length) return new int[0];
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; ++i) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        int[] result = new int[n - k + 1];


        for (int i = k; i < n; ++i) {
            result[i - k] = map.lastKey();
            int value = map.get(nums[i-k]);
            if (value == 1) map.remove(nums[i-k]);
            else map.put(nums[i-k], value - 1);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1); 
        }
        result[n - k] = map.lastKey();
        return result;
    }
}

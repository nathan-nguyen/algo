class Solution {
	public int maxSubArray(int[] nums) {
		if (nums.length == 0) return 0;

		int max = nums[0];
		int total = nums[0];
		for (int i = 1; i < nums.length; ++i){
			if (total + nums[i] < nums[i]) total = nums[i];
			else total += nums[i];
			max = Math.max(max, total);
		}
		return max;
	}
}

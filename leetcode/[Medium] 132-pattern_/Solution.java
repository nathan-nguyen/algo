class Solution {
	public boolean find132pattern(int[] nums) {
		if (nums.length < 3) return false;

		int n = nums.length;
		int min = nums[0], max = nums[0];
		for (int i = 1; i < n; ++i){
			if (nums[i] > min && nums[i] < max) return true;
			else if (nums[i] > max) max = nums[i];
			else if (nums[i] < min) {
				min = nums[i];
				max = nums[i];
			}
		}
		return false;
	}
}

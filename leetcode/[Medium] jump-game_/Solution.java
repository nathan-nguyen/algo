class Solution {
	public boolean canJump(int[] nums) {
		if (nums.length == 0) return false;

		int max = nums[0];
		for (int i = 0; i < nums.length; ++i){
			if (i > max) return false;
			max = Math.max(max, i + nums[i]);
		}
		return true;
	}
}

class Solution {
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i: nums) sum += i;

		if (sum % 2 == 1) return false;

		sum /= 2;
		boolean[] mem = new boolean[sum + 1];
		mem[0] = true;

		for (int i = 0; i < nums.length; ++i) {
			for (int j = sum; j >= nums[i]; --j) {
				mem[j] = mem[j] || mem[j - nums[i]];
			}
			
		}
		return mem[sum];
	}
}

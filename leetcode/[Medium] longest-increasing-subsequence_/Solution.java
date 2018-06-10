class Solution {
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];

		for (int i = 0; i < nums.length; ++i){
			dp[i] = 1;
			for (int j = 0; j < i; ++j){
				if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], 1 + dp[j]);
			}
		}

		int max = 0;
		for (int k : dp) max = Math.max(max, k);
		return max;
	}
}

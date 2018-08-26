class Solution {
	public boolean canPartition(int[] nums) {
		int n = nums.length;
		int sum = 0;

		for (int i : nums) sum += i;

		if (sum % 2 == 1) return false;

		sum /= 2;
		boolean[][] dp = new boolean[n][sum + 1];

		for (int i = 0; i < n; ++i) {
			if (nums[i] <= sum) dp[i][nums[i]] = true;
			for (int j = 0; j < i; ++j) {
				for (int k = 0; k <= sum - nums[i]; ++k) {
					if (dp[j][k]) dp[i][k + nums[i]] = true;
				}
				if (dp[i][sum]) return true;
			}
		}
		return false;
	}
}

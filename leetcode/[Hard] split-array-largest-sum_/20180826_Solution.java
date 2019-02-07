class Solution {
	public int splitArray(int[] nums, int m) {
		int n = nums.length;

		int[][] dp = new int[n][m];

		dp[0][0] = nums[0];
		for (int i = 1; i < n; ++i) dp[i][0] = dp[i-1][0] + nums[i];

		for (int i = 1; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				dp[j][i] = Integer.MAX_VALUE;
				for (int k = 0; k < j; ++k) {
					if (dp[k][i - 1] != Integer.MAX_VALUE) dp[j][i] = Math.min(dp[j][i], Math.max(dp[k][i-1], dp[j][0] - dp[k][0]));
				}
			}
		}

		return dp[n - 1][m - 1];

	}
}

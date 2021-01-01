class Solution {
	// Positive integer n;
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; ++i) {
			int k = (int) Math.sqrt(i);
			if (k * k == i) {
				dp[i] = 1;
				continue;
			}
			dp[i] = Integer.MAX_VALUE;

			for (int j = 1; j * j < i; ++j) dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
		}
		return dp[n];
	}
}

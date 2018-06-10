class Solution {
	public int maxProfit(int[] p) {
		if (p.length == 0) return 0;

		int n = p.length;
		// 0 - Not buy ; 1 - Hold
		int[][] dp = new int[n][2];

		dp[0][0] = 0;
		dp[0][1] = -p[0];

		for (int i = 1; i < n; ++i){
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + p[i]);
			dp[i][1] = dp[i][0] - p[i];
		}

		return Math.max(dp[n-1][0], dp[n-1][1] + p[n-1]);
	}
}

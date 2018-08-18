class Solution {
	public int findRotateSteps(String ring, String key) {
		int n = ring.length();
		int m = key.length();
		int[][] dp = new int[m][n];
	
		for (int i = 0; i < n; ++i) {
			dp[0][i] = Integer.MAX_VALUE;
			if (key.charAt(0) == ring.charAt(i)) dp[0][i] = 1 + Math.min(i, n - i);
		}

		for (int i = 1; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				dp[i][j] = Integer.MAX_VALUE;
				if (key.charAt(i) != ring.charAt(j)) continue;

				for (int k = 0; k < n; ++k) {
					if (dp[i-1][k] != Integer.MAX_VALUE) {
						int move = Math.abs(j - k);
						dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + 1 + Math.min(move, n - move));
					}
				} 
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; ++i) min = Math.min(min, dp[m - 1][i]);

		return min;
	}
}

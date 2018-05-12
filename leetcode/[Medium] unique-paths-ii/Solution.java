class Solution {
	public int uniquePathsWithObstacles(int[][] o) {
		int n = o.length;
		if (n == 0) return 0;

		int m = o[0].length;
		if (m == 0) {
			if (n == 1) return 1;
			return 0;
		}

		if (o[0][0] == 1) return 0;

		int[][] dp = new int[n][m];

		dp[0][0] = 1;
		for (int i = 0; i < n; ++i){
			for (int j = 0; j < m; ++j){
				if (o[i][j] == 1) continue;
				if (i - 1 >= 0) dp[i][j] += dp[i-1][j];
				if (j - 1 >= 0) dp[i][j] += dp[i][j-1];
			}
		}

		return (dp[n-1][m-1] == Integer.MAX_VALUE) ? 0 : dp[n-1][m-1];
        }
}

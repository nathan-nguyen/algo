class Solution {
	public int findPaths(int m, int n, int N, int u, int v) {
		if (N == 0) return 0;

		int MOD = 1000_000_007;

		int[][] total = new int[m][n];
		int[][] dp = new int[m][n];

		for (int i = 0; i < m; ++i){
			for (int j = 0; j < n; ++j){
				int count = 0;
				if (i == 0) ++count;
				if (j == 0) ++count;
				if (i == m - 1) ++count;
				if (j == n - 1) ++count;
				dp[i][j] = count;
				total[i][j] = count;
			}
		}

		for (int k = 2; k <= N; ++k){
			int[][] newdp = new int[m][n];
			for (int i = 0; i < m; ++i){
				for (int j = 0; j < n; ++j){
					if (i > 0) newdp[i][j] = (newdp[i][j] + dp[i-1][j]) % MOD;
					if (j > 0) newdp[i][j] = (newdp[i][j] + dp[i][j-1]) % MOD;
					if (i < m - 1) newdp[i][j] = (newdp[i][j] + dp[i+1][j]) % MOD;
					if (j < n - 1) newdp[i][j] = (newdp[i][j] + dp[i][j+1]) % MOD;
					total[i][j] = (total[i][j] + newdp[i][j]) % MOD;
				}
			}
			dp = newdp;
		}
		return total[u][v];
	}
}

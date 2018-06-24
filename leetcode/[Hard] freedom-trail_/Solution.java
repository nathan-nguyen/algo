class Solution {
	public int findRotateSteps(String ring, String key) {
		if (ring.length() == 0 || key.length() == 0) return 0;

		int n = ring.length();
		int m = key.length();

		int[][] dp = new int[m][n];

		for (int i = 0; i < n; ++i){
			dp[0][i] = Integer.MAX_VALUE;
			if (key.charAt(0) == ring.charAt(i)) dp[0][i] = Math.min(i, n - i);
		}

		for (int i = 1; i < m; ++i){
			for (int j = 0; j < n; ++j){
				dp[i][j] = Integer.MAX_VALUE;
				if (key.charAt(i) != ring.charAt(j)) continue;

				for (int k = 0; k < n; ++k){
					if (key.charAt(i-1) != ring.charAt(k)) continue;
					int diff = Math.abs(j - k);
					int move = Math.min(n - diff, diff);
					dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + move);
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; ++i) min = Math.min(dp[m - 1][i], min);
		return (min == Integer.MAX_VALUE) ? 0 : min + m;
	}
}

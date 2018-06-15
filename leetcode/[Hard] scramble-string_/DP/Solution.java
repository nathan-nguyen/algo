class Solution {
	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length()) return false;

		int n = s1.length();
		boolean[][][] dp = new boolean[n][n][n + 1];

		for (int k = 1; k <= n; ++k){
			for (int i = 0; i + k <= n; ++i){
				for (int j = 0; j + k <= n; ++j){
					if (k == 1) dp[i][j][k] = s1.charAt(i) == s2.charAt(j);
					else for (int c = 1; c < k && !dp[i][j][k]; ++c){
						dp[i][j][k] = (dp[i][j][c] && dp[i+c][j+c][k-c]) || (dp[i][j+k-c][c] && dp[i+c][j][k-c]);
					}
				}
			}
		}
		return dp[0][0][n];
	}
}

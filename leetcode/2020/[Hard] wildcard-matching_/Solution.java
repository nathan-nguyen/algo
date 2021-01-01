class Solution {
	public boolean isMatch(String s, String p) {
		if (p.length() == 0) return s.length() == 0;

		StringBuilder sb = new StringBuilder();
		sb.append(p.charAt(0));

		for (int i = 1; i < p.length(); ++i){
			if (p.charAt(i - 1) == p.charAt(i) && p.charAt(i) == '*') continue;
			sb.append(p.charAt(i));
		}
		p = sb.toString();

		if (p.equals("*")) return true;

		if (s.length() == 0) return false;

		int n = p.length();
		int m = s.length();

		boolean[][] dp = new boolean[n + 1][m + 1];
		dp[0][0] = true;

		for (int i = 1; i <= n; ++i){
			if (p.charAt(i - 1) == '*') {
				for (int j = 1; j <= m; ++j){
					if (i == 1) dp[1][0] = true;
					if (p.charAt(i - 1) == '*'){
						if (dp[i-1][j] || i == 1) {
							for (int k = j; k <= m; ++k) dp[i][k] = true;
							break;
						}
					}
				}
			}
			else {
				for (int j = 1; j <= m; ++j)
	                        	dp[i][j] = dp[i-1][j - 1] && (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?');
                        }
		}
		return dp[n][m];
	}
}

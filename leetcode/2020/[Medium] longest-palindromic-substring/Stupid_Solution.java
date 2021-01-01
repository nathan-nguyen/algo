class Solution {
	public String longestPalindrome(String s) {
		if (s.length() == 0) return "";

		int start = 0,	end = 1;

		boolean [][] dp = new boolean[s.length()][s.length()];

		for (int i = 0; i < s.length(); ++i) dp[i][i] = true;

		for (int i = 0; i < s.length() - 1; ++i) {
			dp[i][i+1] = s.charAt(i) == s.charAt(i + 1);
			if (dp[i][i+1]) {
				start = i;
				end = i + 2;
			}
		}

		for (int d = 3; d <= s.length(); ++d) {
			for (int i = 0; i + d <= s.length(); ++i) {
				dp[i][i + d - 1] = dp[i + 1][i + d - 2] && s.charAt(i) == s.charAt(i + d - 1);
				if (dp[i][i + d - 1] && d > end - start) {
					start = i;
					end = i + d;
				}
			}
		}
		return s.substring(start, end);
	}
}

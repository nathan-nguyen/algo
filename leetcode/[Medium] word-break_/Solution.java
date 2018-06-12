class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		HashSet<String> set = new HashSet<>(wordDict);

		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;

		for (int i = 0; i <= s.length(); ++i){
			if (!dp[i]) continue;
			for (int j = i + 1; j <= s.length(); ++j){
				if (dp[j]) continue;
				dp[j] = set.contains(s.substring(i, j));
			}
		}
		return dp[s.length()];
	}
}

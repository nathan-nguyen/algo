class Solution {
	public List<String> wordBreak(String s, List<String> wordDict) {
		int n = s.length();

		HashSet<String> set = new HashSet<>(wordDict);

		boolean[] dp = new boolean[n + 1];
		dp[0] = true;
		for (int i = 1; i <= n; ++i){
			for (int  j = i; j <= n; ++j){
				dp[j] = dp[j] || (dp[i-1] && set.contains(s.substring(i - 1, j)));
			}
		}
		if (!dp[n]) return new ArrayList<>();

		List<List<String>> l = new ArrayList<>();

                for (int i = 0; i < n; ++i) l.add(new ArrayList<>());

		for (int i = 0; i < n; ++i){
			if (!dp[i]) continue;
			
			for (int j = i + 1; j <= n; ++j){
				String sub = s.substring(i, j);
				if (!set.contains(sub)) continue;

				List<String> nl = l.get(j - 1);
				if (i == 0) nl.add(sub);
				else for (String se: l.get(i - 1)) {
					nl.add(se + " " + sub);
				}
				
			}
		}
		return l.get(n - 1);
	}
}

class Solution {
	public int wordsTyping(String[] st, int r, int c) {
		int n = st.length;
		for (String s: st) if (s.length() > c) return 0;

		int[][] dp = new int[n][2];

		int cur = 0, length = -1;
		for (int i = 0; i < n; ++i) {
			if (i > 0) {
				dp[i][1] = dp[i-1][1];
				length -= st[i-1].length() + 1;
			}
			while (length + 1 + st[cur].length() <= c) {
				length += 1 + st[cur].length();
				if (cur == n - 1) ++dp[i][1];
				cur = (cur + 1) % n;
			}
			dp[i][0] = (cur - 1 + n) % n;
		}

		int ans = 0, next = 0;
		while (r -- > 0) {
			ans += dp[next][1];
			next = (dp[next][0] + 1) % n;
		}

		return ans;
	}
}

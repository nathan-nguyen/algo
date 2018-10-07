class Solution {
	public int wordsTyping(String[] st, int r, int c) {
		int n = st.length;
		for (String s: st) if (s.length() > c) return 0;

		int[] dp = new int[n];

		int cur = 0, length = -1;
		dp[0] = -1;
		for (int i = 0; i < n; ++i) {
			if (i > 0) {
				length -= st[i - 1].length() + 1;
				dp[i] = dp[i-1] - 1;
			}
			while (length <= c) {
				length += 1 + st[cur++ % n].length();
				++dp[i];
			}
		}

		int ans = 0, next = 0;
		while (r -- > 0) {
			ans += dp[next];
			next = (next + dp[next]) % n;
		}

		return ans / n;
	}
}


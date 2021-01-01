class Solution {
	public int numSquares(int n) {
		int[] dp = new int[n+1];

		for (int i = 1; i <= n; ++i){
			int a = (int) Math.sqrt(i);
			if (a * a == i) dp[i] = 1;
			else {
				dp[i] = Integer.MAX_VALUE;
				for (int j = 1; j*j < i; ++j) dp[i] = Math.min(1 + dp[i - j * j], dp[i]);
			}
		}
		return dp[n];
	}
}

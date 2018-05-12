class Solution {
	public int change(int amount, int[] coins) {
		if (amount == 0) return 1;
		if (coins.length == 0) return 0;

		int[] dp = new int[amount + 1];
		dp[0] = 1;

		for (int coin: coins){
			for (int i = 1; i <= amount; ++i) {
				if (i >= coin) dp[i] += dp[i - coin];
			}
		}

		return dp[amount];
	}
}

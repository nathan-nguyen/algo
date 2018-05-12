class Solution {
	public int coinChange(int[] coin, int amount) {
		int[] dp = new int[amount + 1];

		Arrays.sort(coin);

		for (int i = 1; i <= amount; ++i){
			dp[i] = -1;
			for (int j = 0; j < coin.length && coin[j] <= i; ++j){
				int left = i - coin[j];
				if (dp[left] >= 0 &&  (dp[i] > 1 + dp[left] || dp[i] == -1)) dp[i] = dp[left] + 1;
			}
		}
		return dp[amount];
	}
}

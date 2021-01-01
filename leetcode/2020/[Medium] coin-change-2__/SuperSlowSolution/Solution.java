class Solution {
	public int change(int amount, int[] coin) {
		if (amount == 0) return 1;
		if (coin.length == 0) return 0;

		int[][] dp = new int[amount + 1][coin.length];
		for (int i = 0; i < coin.length; ++i) dp[0][i] = 1;

		Arrays.sort(coin);

		for (int i = 1; i <= amount; ++i){
			for (int j = 0; j < coin.length; ++j){
				if (coin[j] <= i) dp[i][j] += dp[i - coin[j]][j];
				for (int k = 0; k < j && coin[k] <= i; ++k){
					dp[i][j] += dp[i - coin[k]][k];
				}
			}
		}
		return dp[amount][coin.length - 1];
	}
}

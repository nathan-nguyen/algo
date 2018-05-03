class Solution {
	public int change(int amount, int[] coin) {
		if (amount == 0) return 1;
		if (coin.length == 0) return 0;

		Arrays.sort(coin);

		int[][] dp = new int[amount + 1][coin.length];

		for (int i = 0; i <= amount; ++i) Arrays.fill(dp[i], -1);

		return change(amount, coin, coin.length - 1, dp);
	}

	private int change(int amount, int[] coin, int index, int[][] dp){
		if (amount == 0) {
			dp[amount][index] = 1;
			return 1;
		}

		if (amount < 0) return 0;

		if (dp[amount][index] >= 0) return dp[amount][index];
		dp[amount][index] = 0;

		dp[amount][index] += change(amount - coin[index], coin, index, dp);

		for (int i = 0; i < index && coin[i] <= amount; ++i) dp[amount][index] += change(amount - coin[i], coin, i, dp);

		return dp[amount][index];
	}
}

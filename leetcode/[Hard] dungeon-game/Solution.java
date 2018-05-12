class Solution {
	public int calculateMinimumHP(int[][] dungeon) {
		int width = dungeon.length;
		int height = dungeon[0].length;

		int[][] dp = new int[width][height];

		for (int i = 0; i < width; ++i) {
			for (int j = 0; j < height; ++j) dp[i][j] = Integer.MAX_VALUE;
		}

		dp[0][0] = 1;
		for (int i = 0; i < width; ++i){
			for (int j = 0; j < height; ++j){
				if (j >= 1) dp[i][j] = Math.max(1, Math.min(dp[i][j], dp[i][j-1] - dungeon[width - 1 - i][height - j]));
				if (i >= 1) dp[i][j] = Math.max(1, Math.min(dp[i][j], dp[i-1][j] - dungeon[width - i][height - 1 - j]));
			}
		}

		return Math.max(dp[width - 1][height - 1] - dungeon[0][0], 1);
	}
}

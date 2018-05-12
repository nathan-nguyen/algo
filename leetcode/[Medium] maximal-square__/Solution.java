class Solution {
	public int maximalSquare(char[][] matrix) {
		int n = matrix.length;

		if (n == 0) return 0;

		int m = matrix[0].length;

		int[][] left = new int[n][m];
		int[][] up = new int[n][m];

		int max = 0;

		for (int i = 0; i < n; ++i){
			for (int j = 0; j < m; ++j){
				if (matrix[i][j] == '0') continue;
				left[i][j] = 1;
				up[i][j] = 1;
				max = 1;
				if (j - 1 >= 0) left[i][j] += left[i][j-1];
				if (i - 1 >= 0) up[i][j] += up[i-1][j];
			}
		}

		int[][] dp = new int[n][m];
		for (int i = 0; i < n; ++i){
			for (int j = 0; j < m; ++j){
				if (matrix[i][j] == '0') continue;
				
				dp[i][j] = 1;

				if (i - 1 >= 0 && j - 1 >= 0) dp[i][j] += Math.min(Math.min(dp[i-1][j-1], left[i][j] - 1), up[i][j] - 1);
				max = Math.max(max, dp[i][j]);
			}
		}
		return max * max;
	}
}

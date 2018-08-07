class Solution {
	public int maximalSquare(char[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) return 0;

		int n = matrix.length;
		int m = matrix[0].length;

		int[][] row = new int[n][m];
		int[][] col = new int[n][m];

		for(int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (matrix[i][j] == '0') continue;
				row[i][j] = 1 + (j > 0 ? row[i][j-1] : 0);
				col[i][j] = 1 + (i > 0 ? col[i-1][j] : 0);
			}
		}

		int[][] dp = new int[n][m];
		int max = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (matrix[i][j] == '0') continue;
				dp[i][j] = 1;

				if (i > 0 && j > 0) {
					dp[i][j] = Math.min(Math.min(row[i][j] - 1, col[i][j] - 1), dp[i-1][j-1]) + 1;
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		return max * max;
	}
}

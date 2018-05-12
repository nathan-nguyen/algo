class NumMatrix {
	private int[][] dp;

	public NumMatrix(int[][] matrix) {
		int n = matrix.length;

		if (n == 0) return;

		int m = matrix[0].length;

		dp = new int[n][m];

		for (int i = 0; i < n; ++i){
			for (int j = 0; j < m; ++j){
				dp[i][j] = matrix[i][j] + ((i - 1 >= 0) ? dp[i-1][j] : 0) + ((j - 1 >= 0) ? dp[i][j-1] : 0) - ((i - 1 >= 0 && j - 1 >= 0) ? dp[i-1][j-1] : 0);
			}
		}
	}
    
	public int sumRegion(int row1, int col1, int row2, int col2) {
		if (dp == null) return 0;
		return dp[row2][col2] - ((row1 - 1 >= 0) ? dp[row1-1][col2]: 0) - ((col1 - 1 >= 0) ? dp[row2][col1-1]: 0) + ((row1 - 1 >= 0 && col1 - 1 >= 0) ? dp[row1-1][col1-1] : 0);
	}
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

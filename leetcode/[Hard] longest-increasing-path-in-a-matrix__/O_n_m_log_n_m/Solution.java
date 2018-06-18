class Solution {
	public int longestIncreasingPath(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) return 0;
		int n = matrix.length;
		int m = matrix[0].length;

		List<int[]> l = new ArrayList<>();
		for (int i = 0; i < n; ++i){
			for (int j = 0; j < m; ++j) l.add(new int[]{i, j});
		}
		l.sort((u, v) -> (matrix[u[0]][u[1]] - matrix[v[0]][v[1]]));

		int[][] dp = new int[n][m];
		int max = 0;

		for (int[] a: l){
			int i = a[0], j = a[1];
			dp[i][j] = 1;
			if (i > 0 && matrix[i][j] > matrix[i-1][j]) dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + 1);
			if (j > 0 && matrix[i][j] > matrix[i][j-1]) dp[i][j] = Math.max(dp[i][j], dp[i][j-1] + 1);
			if (i < n - 1 && matrix[i][j] > matrix[i+1][j]) dp[i][j] = Math.max(dp[i][j], dp[i+1][j] + 1);
			if (j < m - 1 && matrix[i][j] > matrix[i][j+1]) dp[i][j] = Math.max(dp[i][j], dp[i][j+1] + 1);
			max = Math.max(max, dp[i][j]);
		}
		return max;
	}
}

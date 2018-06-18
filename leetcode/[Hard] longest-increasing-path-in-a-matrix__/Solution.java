class Solution {
	public int longestIncreasingPath(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) return 0;
		int n = matrix.length;
		int m = matrix[0].length;

		int[][] mem = new int[n][m];
		int max = 0;
		for (int i = 0; i < n; ++i){
			for (int j = 0; j < m; ++j){
				max = Math.max(max, dfs(matrix, n, m, i, j, mem));
			}
		}
		return max;
	}

	private int dfs(int[][] matrix, int n, int m, int i, int j, int[][] mem){
		if (mem[i][j] != 0) return mem[i][j];

		int max = 1;
		if (i > 0 && matrix[i][j] > matrix[i-1][j]) max = Math.max(max, 1 + dfs(matrix, n, m, i - 1, j, mem));
		if (j > 0 && matrix[i][j] > matrix[i][j-1]) max = Math.max(max, 1 + dfs(matrix, n, m, i, j - 1, mem));
		if (i < n-1 && matrix[i][j] > matrix[i+1][j]) max = Math.max(max, 1 + dfs(matrix, n, m, i + 1, j, mem));
		if (j < m-1 && matrix[i][j] > matrix[i][j+1]) max = Math.max(max, 1 + dfs(matrix, n, m, i, j + 1, mem));

		mem[i][j] = max;
		return mem[i][j];
	}
}


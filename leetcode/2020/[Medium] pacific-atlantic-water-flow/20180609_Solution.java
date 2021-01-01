class Solution {
	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> result = new ArrayList<>();
		if (matrix.length == 0) return result;

		int n = matrix.length;
		int m = matrix[0].length;

		
		boolean[][] p = new boolean[n][m];
		boolean[][] a = new boolean[n][m];

		for (int i = 0; i < m; ++i) {
			dfs(0, i, matrix[0][i], p, n, m, matrix);
			dfs(n-1, i, matrix[n-1][i], a, n, m, matrix);
		}
		for (int i = 0; i < n; ++i) {
			dfs(i, 0, matrix[i][0], p, n, m, matrix);
                        dfs(i, m-1, matrix[i][m-1], a, n, m, matrix);
		}

		for (int i = 0; i < n; ++i){
			for (int j = 0; j < m; ++j){
				if (p[i][j] && a[i][j]) result.add(new int[]{i, j});
			}
		}
		return result;
	}

	private void dfs(int i, int j, int val, boolean[][] f, int n, int m, int[][] matrix){
		if (i < 0 || j < 0 || i >= n || j >= m || f[i][j] || matrix[i][j] < val) return;

		f[i][j] = true;
		dfs(i+1, j, matrix[i][j], f, n, m, matrix);
		dfs(i, j+1, matrix[i][j], f, n, m, matrix);
		dfs(i-1, j, matrix[i][j], f, n, m, matrix);
		dfs(i, j-1, matrix[i][j], f, n, m, matrix);
	}
}

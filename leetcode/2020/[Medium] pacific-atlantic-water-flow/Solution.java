class Solution {
	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> result = new ArrayList<>();
		if (matrix.length == 0 || matrix[0].length == 0) return result;

		int n = matrix.length;
		int m = matrix[0].length;

		boolean[][] visited = new boolean[n][m];
		boolean[][] p = new boolean[n][m];
		boolean[][] a = new boolean[n][m];

		for (int i = 0; i < m; ++i) {
			dfs(0, i, 0, matrix, p);
			dfs(n - 1, i, 0, matrix, a);
		}

		for (int i = 0; i < n; ++i) {
			dfs(i, 0, 0, matrix, p);
			dfs(i, m - 1, 0, matrix, a);
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (p[i][j] && a[i][j]) result.add(new int[]{i, j});
			}
		}
		return result;
	}

	private void dfs(int i, int j, int val, int[][] matrix, boolean[][] f) {
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || f[i][j] || matrix[i][j] < val) return;

		f[i][j] = true;
		dfs(i, j + 1, matrix[i][j], matrix, f);
		dfs(i, j - 1, matrix[i][j], matrix, f);
		dfs(i + 1, j, matrix[i][j], matrix, f);
		dfs(i - 1, j, matrix[i][j], matrix, f);
	}
}

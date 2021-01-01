class Solution {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> l = new ArrayList<>();

		if (n == 0) return l;
		boolean[] col = new boolean[n];
		boolean[] left = new boolean[2 * n - 1];
		boolean[] right = new boolean[2 * n - 1];
		boolean[][] map = new boolean[n][n];

		solve(n, 0, col, left, right, map, l);
		return l;
	}

	private void solve(int n, int k, boolean[] col, boolean[] left, boolean[] right, boolean[][] map, List<List<String>> l){
		if (k == n){
			List<String> le = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; ++i){
				sb.setLength(0);
				for (int j = 0; j < n; ++j){
					if (map[i][j]) sb.append('Q');
					else sb.append('.');
				}
				le.add(sb.toString());
			}
			l.add(le);
		}

		// [k][i]
		for (int i = 0; i < n; ++i){
			if (col[i] || left[k + i] || right[n - 1 - k + i]) continue;
			col[i] = true;
			left[k+i] = true;
			right[n-1-k+i] = true;
			map[k][i] = true;
			solve(n, k + 1, col, left, right, map, l);
			map[k][i] = false;
			right[n-1-k+i] = false;
			left[k+i] = false;
			col[i] = false;
		}	
	}
}

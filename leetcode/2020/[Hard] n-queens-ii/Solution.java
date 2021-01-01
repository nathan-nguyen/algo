class Solution {
	private int count;

	public int totalNQueens(int n) {
		if (n <= 1) return n;

		count = 0;

		boolean[] col = new boolean[n];
		boolean[] left = new boolean[n * 2 - 1];
		boolean[] right = new boolean[n * 2 - 1];

		solve(0, n, col, left, right);
		return count;
	}

	private void solve(int k, int n, boolean[] col, boolean[] left, boolean[] right){
		if (k == n) {
			++count;
			return;
		}

		for (int i = 0; i < n; ++i){
			if (col[i] || left[k + i] || right[k - i + n - 1]) continue;
			col[i] = true;
			left[k+i] = true;
			right[k - i + n - 1] = true;
			solve(k + 1, n, col, left, right);
			col[i] = false;
			left[k+i] = false;
			right[k - i + n - 1] = false;
		}
	}
}

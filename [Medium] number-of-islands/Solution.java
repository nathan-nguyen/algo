class Solution {
	public int numIslands(char[][] grid) {
		int n = grid.length;
		if (n == 0) return 0;

		int m = grid[0].length;

		int count = 0;
		for (int i = 0; i < n; ++i){
			for (int j = 0; j < m; ++j){
				if (grid[i][j] == '0') continue;
				if (i >= 1 && grid[i-1][j] == '1') continue;
				if (j >= 1 && grid[i][j-1] == '1') continue;
				++count;
			}
		}
		return count;
	}
}

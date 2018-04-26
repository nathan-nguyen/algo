class Solution {
	public int numIslands(char[][] grid) {
		int n = grid.length;
		if (n == 0) return 0;

		int m = grid[0].length;

		int[] u = new int[n * m];
		for (int i = 0; i < u.length; ++i) u[i] = i;

		int[] sz = new int[n * m];
		Arrays.fill(sz, 1);

		int count = 0;
		for (int i = 0; i < n; ++i){
			for (int j = 0; j < m; ++j){
				if (grid[i][j] == '0') continue;
				int k = i * n + j;
				boolean found = false;
				if (i >= 1 && grid[i-1][j] == '1') {
					int k1 = (i - 1) * n + j;
					union(u, sz, k1, k);
					found = true;
				}
				if (j >= 1 && grid[i][j-1] == '1') {
					int k1 = i * n + (j - 1);
					if (!union(u, sz, k1, k) && found) --count;
					found = true;
				}
				if (!found) ++count;
			}
		}
		return count;
	}

	private boolean union(int[] u, int[] sz, int k1, int k2){
		while (u[k1] != k1) k1 = u[k1];
                while (u[k2] != k2) k2 = u[k2];
                if (k1 == k2) return true;
                else if (sz[k1] < sz[k2]) {
                	u[k1] = k2;
                        sz[k2] += sz[k1];
                }
                else {
                        u[k2] = k1;
                	sz[k1] += sz[k2];
                }
		return false;
	}
}

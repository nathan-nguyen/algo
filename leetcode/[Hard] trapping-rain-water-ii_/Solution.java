class Solution {
	// m <= 100 ; n <= 100
	public int trapRainWater(int[][] map) {
		if (map.length == 0 || map[0].length == 0) return 0;

		int m = map.length;
		int n = map[0].length;

		int[][] left = new int[m][n];
		int[][] right = new int[m][n];
		int[][] up = new int[m][n];
		int[][] down = new int[m][n];

		for (int i = 0; i < m; ++i){
			for (int j = 0; j < n; ++j){
				if (i == 0) {
					up[0][j] = map[0][j];
					down[m-1][j] = map[m-1][j];
				}
				else {
					up[i][j] = Math.max(map[i][j], up[i-1][j]);
					down[m-1-i][j] = Math.max(map[m-1-i][j], down[m-1-i+1][j]);
				}
				if (j == 0) {
					left[i][0] = map[i][0];
					right[i][n-1] = map[i][n-1];
				}
				else {
					left[i][j] = Math.max(map[i][j], left[i][j-1]);
					right[i][n-1-j] = Math.max(map[i][n-1-j], right[i][n-1-j+1]);
				}
			}
		}

		int count = 0;
		for (int i = 0; i < m; ++i){
			for (int j = 0; j < n; ++j) count += Math.min(Math.min(Math.min(left[i][j], right[i][j]), up[i][j]), down[i][j]) - map[i][j];
		}
		return count;
	}
}

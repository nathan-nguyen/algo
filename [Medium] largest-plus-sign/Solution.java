class Solution {
	public int orderOfLargestPlusSign(int n, int[][] mines) {
		int[][] a = new int[n][n];

		for (int i = 0; i < n; ++i){
			Arrays.fill(a[i], 1);
		}

		for (int i = 0; i < mines.length; ++i) a[mines[i][0]][mines[i][1]] = 0;

		int[][] left = new int[n][n];
		int[][] right = new int[n][n];
		int[][] up = new int[n][n];
		int[][] down = new int[n][n];

		int max = 0;

		for (int i = 0; i < n; ++i){
			for (int j = 0; j < n; ++j){
				if (a[i][j] == 0) continue;

				max = 1;

				left[i][j] = 1;
				up[i][j] = 1;
				if (j - 1 >= 0) left[i][j] += left[i][j-1];
				if (i - 1 >= 0) up[i][j] += up[i-1][j];
			}
		}

		if (max == 0) return 0;

		for (int i = n-1; i >=0; --i){
                        for (int j = n-1; j >= 0; --j){
                                if (a[i][j] == 0) continue;
                                
                                right[i][j] = 1;
                               	down[i][j] = 1;
                                if (j + 1 < n) right[i][j] += right[i][j+1];
                                if (i + 1 < n) down[i][j] += down[i+1][j];
                        }
                }

		for (int i = 0; i < n; ++i){
			for (int j = 0; j < n; ++j){
				if (a[i][j] == 0) continue;

				max = Math.max(max, Math.min(Math.min(Math.min(left[i][j], right[i][j]),up[i][j]),down[i][j]));
			}
		}

		return max;	
	}
}

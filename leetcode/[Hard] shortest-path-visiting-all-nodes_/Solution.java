class Solution {
    public int shortestPathLength(int[][] g) {
        int n = g.length;
        int[][] dp = new int[1 << n][n];
        for (int[] x: dp) Arrays.fill(x, Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) dp[1 << i][i] = 0;

        for (int i = 0; i < 1 << n; ++i) {
            boolean flag = true;
            while (flag) {
                flag = false;
                for (int j = 0; j < n; ++j) {
                    if (dp[i][j] == Integer.MAX_VALUE || ((i >> j) & 1) == 0) continue;
                    for (int k: g[j]) {
                        int x = i | (1 << k);
                        if (dp[x][k] > dp[i][j] + 1) {
                            dp[x][k] = dp[i][j] + 1;
                            flag = true;
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) min = Math.min(dp[(1 << n) - 1][i], min);
        return min;
    }
}

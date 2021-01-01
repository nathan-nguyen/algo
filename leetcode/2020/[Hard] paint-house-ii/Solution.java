class Solution {
    public int minCostII(int[][] cost) {
        if (cost.length == 0 ) return 0;
        int n = cost.length;
        int m = cost[0].length;

        int[][]dp = new int[n][m];
        for (int j = 0; j < m; ++j) dp[0][j] = cost[0][j];

        for (int i = 1; i < n; ++i) {
            int[] minLeft = new int[m];
            int[] minRight = new int[m];
            minLeft[0] = dp[i-1][0];
            for (int j = 1; j < m; ++j) minLeft[j] = Math.min(minLeft[j-1], dp[i-1][j]);
            minRight[m-1] = dp[i-1][m-1];
            for (int j = m-2; j >= 0; --j) minRight[j] = Math.min(minRight[j+1], dp[i-1][j]);

            for (int j = 0; j < m; ++j) {
                int k = Math.min(j == 0 ? Integer.MAX_VALUE : minLeft[j-1], j == m - 1 ? Integer.MAX_VALUE : minRight[j+1]);
                dp[i][j] = cost[i][j] + k;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < m; ++j) min = Math.min(min, dp[n-1][j]);
        return min;
    }
}


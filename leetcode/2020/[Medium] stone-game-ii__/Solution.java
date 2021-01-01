public class Solution {
    public int stoneGameII(int[] p) {
        int n = p.length;
        if (n == 0) return 0;

        int[] sum = new int[n];
        int[][] dp = new int[n][n];

        sum[n-1] = p[n-1];
        for (int i = n-2; i >= 0; --i) sum[i] = sum[i+1] + p[i];

        return dfs(0, 1, n, dp, sum);
    }

    private int dfs(int i, int j, int n, int[][] dp, int[] sum) {
        if (dp[i][j] != 0) return dp[i][j];
        if (n - i <= 2 * j) dp[i][j] = sum[i];
        else {
            int min = Integer.MAX_VALUE;
            for (int k = 1; k <= 2 * j; ++k) {
                min = Math.min(min, dfs(i + k, Math.max(k, j), n, dp, sum));
            }
            dp[i][j] = sum[i] - min;
        }
        return dp[i][j];
    }
}


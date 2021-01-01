class Solution {
    public int splitArray(int[] a, int m) {
        int n = a.length;

        int[] total = new int[n];
        total[0] = a[0];
        for (int i = 1; i < n; ++i) total[i] = total[i-1] + a[i];

        int[][] dp = new int[n][m+1];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][1] = total[i];
        }

        for (int j = 1; j <= m; ++j) {
            for (int i = 0; i < n; ++i) {
                for (int k = 0; k < i; ++k) {
                    if (dp[k][j - 1] != Integer.MAX_VALUE) dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j-1], sumQuery(k + 1, i, total)));
                }
            }
        }

        return dp[n-1][m];
    }

    // Inclusive
    private int sumQuery(int start, int end, int[] total) {
        if (start == 0) return total[end];
        else return total[end] - total[start - 1];
    }
}

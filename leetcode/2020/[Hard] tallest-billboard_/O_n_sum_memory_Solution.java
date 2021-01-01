class Solution {
    public int tallestBillboard(int[] a) {
        if (a.length == 0) return 0;
        int n = a.length;
        int sum = 0;
        for (int i: a) sum += i;

        int[][] dp = new int[n][sum * 2 + 1];

        for (int i = 0; i < n; ++i) Arrays.fill(dp[i], Integer.MIN_VALUE);
        dp[0][sum] = dp[0][sum - a[0]] = 0;
        dp[0][sum + a[0]] = a[0];

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < 2 * sum + 1; ++j) {
                if (j >= a[i]) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - a[i]] >= 0 ? dp[i-1][j-a[i]] + a[i] : Integer.MIN_VALUE);
                if (j + a[i] < 2 * sum + 1) dp[i][j] = Math.max(dp[i][j], Math.max(dp[i-1][j], dp[i-1][j + a[i]]));
            }
        }
        return dp[n-1][sum];
    }
}

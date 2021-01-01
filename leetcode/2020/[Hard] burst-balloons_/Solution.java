class Solution {
    public int maxCoins(int[] nums) {
        int[] a = new int[nums.length + 2];
        int n = 1;
        for (int k: nums) {
            if (k > 0) a[n++] = k;
        }
        a[0] = a[n++] = 1;

        int[][] dp = new int[n][n];
        return maxCoins(a, dp, 0, n - 1);
    }

    private int maxCoins(int[] a, int[][] dp, int start, int end) {
        if (start + 1 == end) return 0;
        if (dp[start][end] > 0) return dp[start][end];

        for (int i = start + 1; i < end; ++i) {
            dp[start][end] = Math.max(dp[start][end], maxCoins(a, dp, start, i) + maxCoins(a, dp, i, end) + a[start] * a[end] * a[i]);
        }
        return dp[start][end];
    }
}

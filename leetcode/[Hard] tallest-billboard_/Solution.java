class Solution {
    public int tallestBillboard(int[] a) {
        int n = a.length;
        int sum = 0;
        for (int i: a) sum += i;

        int[] cur = new int[sum * 2 + 1];
        int[] dp = new int[sum * 2 + 1];

        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[sum] = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 2 * sum + 1; ++j) cur[j] = dp[j];
            for (int j = 0; j < 2 * sum + 1; ++j) {
                if (j >= a[i]) dp[j] = Math.max(cur[j], cur[j - a[i]] >= 0 ? cur[j-a[i]] + a[i] : Integer.MIN_VALUE);
                if (j + a[i] < 2 * sum + 1) dp[j] = Math.max(dp[j], Math.max(cur[j], cur[j + a[i]]));
            }
        }
        return dp[sum];
    }
}

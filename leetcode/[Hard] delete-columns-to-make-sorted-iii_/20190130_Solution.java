class Solution {
    public int minDeletionSize(String[] a) {
        if (a.length == 0 || a[0].length() == 0) return 0;
        int n = a.length;
        int m = a[0].length();

        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i < m; ++i) {
            middle:for (int j = 0; j < i; ++j) {
                for (int k = 0; k < n; ++k) {
                    if (a[k].charAt(i) < a[k].charAt(j)) continue middle;
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return m - max;
    }
}

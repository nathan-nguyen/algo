class Solution {
    public int minDeletionSize(String[] a) {
        int n = a.length;
        int m = a[0].length();
        int[] dp = new int[m];
        int max = 0;
        for (int i = 0; i < m; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (check(a, j, i, n)) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return m - max;
    }

    private boolean check(String[] a, int x, int k, int n) {
        for (int i = 0; i < n; ++i) {
            if (a[i].charAt(x) > a[i].charAt(k)) return false;
        }
        return true;
    }
}

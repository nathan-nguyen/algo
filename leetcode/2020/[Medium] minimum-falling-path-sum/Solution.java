class Solution {
    public int minFallingPathSum(int[][] a) {
        int n = a.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; ++i) {
            int[] next = new int[n];
            for (int j = 0; j < n; ++j) {
                next[j] = dp[j];
                if (j >= 1) next[j] = Math.min(next[j], dp[j-1]);
                if (j < n - 1) next[j] = Math.min(next[j], dp[j+1]);
                next[j] += a[i][j];
            }
            dp = next;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) min = Math.min(min, dp[i]);
        return min;
    }
}

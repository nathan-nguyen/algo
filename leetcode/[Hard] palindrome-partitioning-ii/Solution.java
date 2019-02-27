class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) Arrays.fill(dp[i], -1);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; i - j >= 0 && i + j < n; ++j) {
                if (s.charAt(i - j) != s.charAt(i + j)) break;
                dp[i - j][i + j] = 0;
            }
            for (int j = 0; i - j >= 0 && i + 1 + j < n; ++j) {
                if (s.charAt(i - j) != s.charAt(i + 1 + j)) break;
                dp[i - j][i + 1 + j] = 0;
            }
        }
        return minCut(0, n - 1, dp);
    }

    private int minCut(int start, int end, int[][] dp) {
        if (dp[start][end] >= 0) return dp[start][end];
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; ++i) {
            min = Math.min(min, 1 + minCut(start, i, dp) + minCut(i + 1, end, dp));
        }
        dp[start][end] = min;
        return min;
    }
}


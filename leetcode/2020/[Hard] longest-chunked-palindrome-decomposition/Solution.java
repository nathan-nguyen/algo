class Solution {
    public int longestDecomposition(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        return dfs(s, dp, 0, n-1);
    }

    private int dfs(String s, int[][] dp, int i, int j) {
        if (i > j) return 0;    // Might be redundant
        if (dp[i][j] != 0) return dp[i][j];
        if (i == j) dp[i][j] = 1;
        else if (i + 1 == j) dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
        else {
            dp[i][j] = 1;
            for (int k = 0; i + 2 * k <= j; ++k) {
                if (s.substring(i, i + k + 1).equals(s.substring(j - k, j + 1))) dp[i][j] = Math.max(dp[i][j], 2 + dfs(s, dp, i + k + 1, j - k - 1));
            }
        }
        return dp[i][j];
    }
}

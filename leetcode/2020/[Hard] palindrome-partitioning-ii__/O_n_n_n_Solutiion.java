class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int d = 1; d < n; ++d) {
            for (int i = 0; i + d < n; ++i) {
                if (s.charAt(i) == s.charAt(i + d) && (d == 1 || dp[i + 1][i + d - 1] == 0)) continue;
                dp[i][i + d] = Integer.MAX_VALUE;
                for (int k = i; k < i + d; ++k) dp[i][i + d] = Math.min(dp[i][i + d], dp[i][k] + 1 + dp[k + 1][i + d]);
            }
        }
        return dp[0][n-1];
    }
}

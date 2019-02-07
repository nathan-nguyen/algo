class Solution {
    public int longestPalindromeSubseq(String s1) {
        String s2 = (new StringBuilder(s1)).reverse().toString();
        int n = s1.length();

        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                dp[i][j] = Math.max(Math.max(dp[i][j], dp[i-1][j]), dp[i][j-1]);
            }
        }
        int max = 1;
        for (int i = 0; i < n; ++i ) max = Math.max(max, 2 * dp[i+1][n-1-i]);
        for (int i = 1; i < n - 1; ++i) max = Math.max(max, 1 + 2 * dp[i][n - i - 1]);
        return max;
    }
}

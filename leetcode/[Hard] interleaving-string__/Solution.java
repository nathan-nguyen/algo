class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        int n = s1.length();
        int m = s2.length();
        boolean[][] dp = new boolean[n+1][m+1];

        for (int i = 0; i <= n; ++i) dp[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        for (int j = 0; j <= m; ++j) dp[0][j] = s2.substring(0, j).equals(s3.substring(0, j));

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                dp[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i-1][j]) || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j-1]);
            }
        }

        return dp[n][m];
    }
}

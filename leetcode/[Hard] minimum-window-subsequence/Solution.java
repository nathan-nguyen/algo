class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        int[][][] dp = new int[n + 1][m + 1][2];

        for (int j = 1; j <= m; ++j) {
            for (int i = 1; i <= n; ++i) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j][0] = dp[i-1][j-1][0] + 1;
                    if (j == 1) dp[i][1][1] = i - 1;
                    else dp[i][j][1] = dp[i-1][j-1][1];
                }
                if (dp[i][j][0] <= dp[i-1][j][0]) {
                    dp[i][j][0] = dp[i-1][j][0];
                    dp[i][j][1] = Math.max(dp[i][j][1], dp[i-1][j][1]);
                }
                if (dp[i][j][0] <= dp[i][j-1][0]) {
                    dp[i][j][0] = dp[i][j-1][0];
                    dp[i][j][1] = Math.max(dp[i][j][1], dp[i][j-1][1]);
                }
            }
        }
        int minLength = Integer.MAX_VALUE;
        int start = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length(); ++i) {
            if (dp[i][m][0] == m && i - dp[i][m][1] <= minLength) {
                start = (i - dp[i][m][1] < minLength) ? dp[i][m][1] : Math.min(start, dp[i][m][1]);
                minLength = i - dp[i][m][1];
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}



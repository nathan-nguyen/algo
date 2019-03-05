class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, end = 0;
        for (int i = 0; i < n; ++i) dp[i][i] = true;
        for (int i = 0; i < n - 1; ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                start = i;
                end = i + 1;
                dp[i][i + 1] = true;
            }
        }

        for (int d = 2; d < n; ++d) {
            for (int i = 0; i + d < n; ++i) {
                dp[i][i + d] = (s.charAt(i) == s.charAt(i + d)) && dp[i+1][i + d - 1];
                if (dp[i][i+d] && d > end - start) {
                    start = i;
                    end = i + d;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}

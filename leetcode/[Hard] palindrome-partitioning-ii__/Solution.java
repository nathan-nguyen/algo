class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];

        for (int i = 0; i < n; ++i) dp[i][i] = true;
        for (int i = 0; i + 1 < n; ++i) dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);

        for (int d = 2; d < n; ++d) {
            for (int i = 0; i + d < n; ++i) {
                dp[i][i + d] = dp[i + 1][i + d - 1] && s.charAt(i) == s.charAt(i + d);
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; ++i) {
            if (dp[0][i]) continue;
            result[i] = Integer.MAX_VALUE;
            for (int k = 0; k < i; ++k) {
                if (dp[k+1][i]) result[i] = Math.min(result[i], result[k] + 1);
            }
        }
        return result[n-1];
    }
}

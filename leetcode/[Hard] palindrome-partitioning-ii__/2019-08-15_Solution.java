class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; i - j >= 0 && i + j < n; ++j) {
                if (s.charAt(i - j) != s.charAt(i + j)) break;
                dp[i - j][i + j] = true;
            }
            for (int j = 0; i - j >= 0 && i + 1 + j < n; ++j) {
                if (s.charAt(i - j) != s.charAt(i + 1 + j)) break;
                dp[i - j][i + 1 + j] = true;
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; ++i) {
            if (dp[0][i]) {
                result[i] = 0;
                continue;
            }
            result[i] = i + 1;
            for (int j = 1; j <= i; ++j) {
                if (dp[j][i]) result[i] = Math.min(result[i], 1 + result[j - 1]);
            }
        }
        return result[n-1];
    }
}


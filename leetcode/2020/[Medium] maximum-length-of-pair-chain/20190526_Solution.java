class Solution {
    public int findLongestChain(int[][] p) {
        int n = p.length;
        Arrays.sort(p, (u, v) -> Integer.compare(u[0], v[0]));
        int[] dp = new int[n];

        int max = 0;
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (p[j][1] < p[i][0]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

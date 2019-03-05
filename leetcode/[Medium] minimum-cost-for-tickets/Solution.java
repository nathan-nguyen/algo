class Solution {
    public int mincostTickets(int[] d, int[] c) {
        int[] dp = new int[366];
        boolean[] t = new boolean[366];
        for (int k: d) t[k] = true;

        for (int i = 1; i < 366; ++i) {
            if (!t[i]) {
                dp[i] = dp[i-1];
                continue;
            }
            dp[i] = Math.min(Math.min(dp[i-1] + c[0], i < 7 ? c[1] : c[1] + dp[i - 7]), i < 30 ? c[2] : c[2] + dp[i-30]);
        }
        return dp[365];
    }
}


class Solution {
    public int shortestPathLength(int[][] g) {
        int n = g.length;
        int[][] dp = new int[1 << n][n];
        for (int[] x: dp) Arrays.fill(x, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            dp[1 << i][i] = 0;
            queue.offer(new int[]{1 << i, i});
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == (1 << n) - 1) return dp[cur[0]][cur[1]];
            for (int k: g[cur[1]]) {
                int x = cur[0] | (1 << k);
                if (dp[x][k] > dp[cur[0]][cur[1]] + 1) {
                    dp[x][k] = dp[cur[0]][cur[1]] + 1;
                    queue.offer(new int[]{x, k});
                }
            }
        }
        throw new AssertionError();
    }
}

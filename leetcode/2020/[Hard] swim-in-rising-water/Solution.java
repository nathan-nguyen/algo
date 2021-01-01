class Solution {
    public int swimInWater(int[][] g) {
        int n = g.length;
        Queue<int[]> queue = new PriorityQueue<>((u, v) -> Integer.compare(u[2], v[2]));
        int[][] map = new int[n][n];

        queue.offer(new int[]{0, 0, g[0][0]});
        for (int i = 0; i < n; ++i) Arrays.fill(map[i], Integer.MAX_VALUE);
        map[0][0] = g[0][0];
        while (!queue.isEmpty()) {
            int[] val = queue.poll();
            int x = val[0];
            int y = val[1];
            if (map[val[0]][val[1]] != val[2]) continue;
            if (x == n - 1 && y == n - 1) return val[2];

            process(x, y + 1, val[2], g, map, queue, n);
            process(x + 1, y, val[2], g, map, queue, n);
            process(x, y - 1, val[2], g, map, queue, n);
            process(x - 1, y, val[2], g, map, queue, n);
        }
        return -1;
    }

    private void process(int i, int j, int cur, int[][] g, int[][] map, Queue<int[]> queue, int n) {
        if (i < 0 || i >= n || j < 0 || j >= n) return;
        int max = Math.max(cur, g[i][j]);
        if (max >= map[i][j]) return;
        queue.offer(new int[]{i, j, max});
        map[i][j] = max;
    }
}

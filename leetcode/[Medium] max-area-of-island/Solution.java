class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) return 0;
        
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int max = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                max = Math.max(max, dfs(i, j, grid, visited, n, m));
            }
        }
        return max;
    }

    private int dfs(int i, int j, int[][] grid, boolean[][] visited, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0 || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, grid, visited, n, m)
            + dfs(i - 1, j, grid, visited, n, m)
            + dfs(i, j + 1, grid, visited, n, m)
            + dfs(i, j - 1, grid, visited, n, m);
    }
}

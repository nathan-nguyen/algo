class Solution {
    public int numIslands(char[][] g) {
        if (g.length == 0 || g[0].length == 0) return 0;
        int n = g.length;
        int m = g[0].length;

        int count = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (g[i][j] == '0' || visited[i][j]) continue;
                ++count;
                dfs(i, j, n, m, g, visited);
            }
        }
        return count;
    }

    private void dfs(int i, int j, int n, int m, char[][] g, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= n || j >= m || g[i][j] == '0' || visited[i][j]) return;
        visited[i][j] = true;
        dfs(i, j + 1, n, m, g, visited);
        dfs(i + 1, j, n, m, g, visited);
        dfs(i, j - 1, n, m, g, visited);
        dfs(i - 1, j, n, m, g, visited);
    }
}

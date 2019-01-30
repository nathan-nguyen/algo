class Solution {
    public int regionsBySlashes(String[] grid) {
        if (grid.length == 0) return 0;
        int n = grid.length;
        boolean[][][] visited = new boolean[n][n][4];

        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < 4; ++k) {
                    if (visited[i][j][k]) continue;
                    ++count;
                    dfs(grid, visited, i, j, k, n);
                }
            }
        }
        return count;
    }

    // 0 - down, 1 - right, 2 - up, 3 - left
    private void dfs(String[] grid, boolean[][][] visited, int i, int j, int k, int n) {
        if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j][k]) return;
        visited[i][j][k] = true;

        switch (k) {
            case 0: dfs(grid, visited, i + 1, j, 2, n); break;
            case 1: dfs(grid, visited, i, j + 1, 3, n); break;
            case 2: dfs(grid, visited, i - 1, j, 0, n); break;
            case 3: dfs(grid, visited, i, j - 1, 1, n); break;
        }

        if (grid[i].charAt(j) == ' ') {
            for (int x = 0; x < 4; ++x) dfs(grid, visited, i, j, x, n);
        }
        else if (grid[i].charAt(j) == '/') {
            switch (k) {
                case 0: dfs(grid, visited, i, j, 1, n); break;
                case 1: dfs(grid, visited, i, j, 0, n); break;
                case 2: dfs(grid, visited, i, j, 3, n); break;
                case 3: dfs(grid, visited, i, j, 2, n); break;
            }
        }
        else {
            switch (k) {
                case 0: dfs(grid, visited, i, j, 3, n); break;
                case 1: dfs(grid, visited, i, j, 2, n); break; 
                case 2: dfs(grid, visited, i, j, 1, n); break;
                case 3: dfs(grid, visited, i, j, 0, n); break;
            }
        }
    } 
}

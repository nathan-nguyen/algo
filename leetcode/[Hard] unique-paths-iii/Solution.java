class Solution {
    public int uniquePathsIII(int[][] g) {
        int n = g.length;
        int m = g[0].length;
        int visited = 0;
        int startX = -1, startY = -1, endX = -1, endY = -1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (g[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
                else if (g[i][j] == 2) {
                    endX = i;
                    endY = j;
                }
                else if (g[i][j] == -1) visited |= (1 << (i * m + j));
            }
        }

        return dfs(startX, startY, endX, endY, visited, n, m);
    }

    private int dfs(int i, int j, int endx, int endy, int visited, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || ((visited >> (i * m + j)) & 1) == 1) return 0;
        visited |= (1 << (i * m + j));
        int result = 0;
        if (i == endx && j == endy) {
            if (visited == (1 << (n * m)) - 1) result = 1;
        }
        else {
            result += dfs(i, j + 1, endx, endy, visited, n, m);
            result += dfs(i + 1, j, endx, endy, visited, n, m);
            result += dfs(i, j - 1, endx, endy, visited, n, m);
            result += dfs(i - 1, j, endx, endy, visited, n, m);
        }
        visited ^= (1 << (i * m + j));
        return result;
    }
}

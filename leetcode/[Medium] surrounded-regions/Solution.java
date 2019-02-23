class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) dfs(i, j, n, m, board, visited);
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (!visited[i][j] && board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    private void dfs(int i, int j, int n, int m, char[][] board, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= n || j >= m || board[i][j] == 'X' || visited[i][j]) return;
        visited[i][j] = true;
        dfs(i, j + 1, n, m, board, visited);
        dfs(i + 1, j, n, m, board, visited);
        dfs(i, j - 1, n, m, board, visited);
        dfs(i - 1, j, n, m, board, visited);
    }
}

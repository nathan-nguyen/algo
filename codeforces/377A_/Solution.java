import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        char[][] g = new char[n][m];
        for (int i = 0; i < n; ++i) {
            String s = in.next();
            g[i] = s.toCharArray();
        }

        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) k = dfs(i, j, n, m, g, visited, k);
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) System.out.print(g[i][j]);
            System.out.println();
        }
    }

    private int dfs(int i, int j, int n, int m, char[][] g, boolean[][] visited, int k) {
        if (k == 0 || i < 0 || j < 0 || i >= n || j >= m || g[i][j] == '#' || visited[i][j]) return k;

        visited[i][j] = true;
        k = dfs(i, j + 1, n, m, g, visited, k);
        if (k > 0) k = dfs(i + 1, j, n, m, g, visited, k);
        if (k > 0) k = dfs(i, j - 1, n, m, g, visited, k);
        if (k > 0) k = dfs(i - 1, j, n, m, g, visited, k);
        if (k > 0) {
            --k;
            g[i][j] = 'X';
        }
        return k;
    }
}

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t -- > 0) {
            int n = in.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) a[i][j] = in.nextInt();
            }

            int[][] dp = new int[n][n];
            int max = 0;
            for (int i = 0; i < n; ++i) max = Math.max(max, dfs(0, i, n, dp, a));
            System.out.println(max);
        }
    }

    private int dfs(int i, int j, int n, int[][] dp, int[][] a) {
        if (j < 0 || i >= n || j >= n) return 0;
        if (dp[i][j] > 0) return dp[i][j];

        dp[i][j] = Math.max(dp[i][j], dfs(i + 1, j - 1, n, dp, a));
        dp[i][j] = Math.max(dp[i][j], dfs(i + 1, j, n, dp, a));
        dp[i][j] = Math.max(dp[i][j], dfs(i + 1, j + 1, n, dp, a));
        dp[i][j] += a[i][j];
        return dp[i][j];
    }
}

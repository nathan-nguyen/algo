import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int m = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; ++i) a[i] = in.nextInt();

        long[][] dp = new long[n][m+1];
        for (int i = 0; i < d && i < n; ++i) dp[i][1] = a[i];

        for (int j = 2; j <= m; ++j) {
            for (int i = 0; i < n; ++i) {
                for (int k = i - 1; k >= 0 && k >= i - d; --k) {
                    if (dp[k][j-1] > 0) dp[i][j] = Math.max(dp[i][j], dp[k][j-1] + a[i]);
                }
            }
        }
        long max = 0;
        for (int i = 1; i <= d && i <= n; ++i) max = Math.max(max, dp[n-i][m]);
        System.out.println(max > 0 ? max : -1);
    }
}


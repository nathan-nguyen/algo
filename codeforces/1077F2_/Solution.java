import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int x = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) a[i] = in.nextInt();

        int[][] dp = new int[n][x+1];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
            dp[i][1] = a[i];
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 2; j <= x; ++j) {
                for (int d = 1; d <=k; ++d) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-d][j-1] + a[i]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; ++i) max = Math.max(max, dp[n - 1 - i][x])
        System.out.println(max == Integer.MIN_VALUE ? 1 : max);
    }
}

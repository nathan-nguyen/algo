import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private static final int MOD = 1000_000_007;

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) a[i] = in.nextInt();
        long[] dp = new long[n+1];

        dp[0] = 1;
        for (int i = 0; i < n; ++i) {
            int j = 1;
            while (j * j <= a[i]) {
                if (a[i] % j == 0 && a[i] / j <= n) {
                    int x = a[i] / j;
                    dp[x] = (dp[x] + dp[x-1]) % MOD;
                }
                ++j;
            }
            --j;
            if (j * j == a[i]) --j;
            while (j > 0) {
                if (a[i] % j == 0 && j <= n) dp[j] = (dp[j] + dp[j-1]) % MOD;
                --j;
            }
        }

        long total = 0;
        for (int i = 1; i <= n; ++i) total = (total + dp[i]) % MOD;
        System.out.println(total);
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        System.out.println(new Solution().solve());
    }

    private int solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] dp = new int[n+1];

        Arrays.fill(dp, 1);
        for (int x = 2; x <= k; ++x) {
            int[] cur = new int[n+1];
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (i * j > n) break;
                    cur[i * j] = (cur[i * j] + dp[i]) % MOD;
                }
            }
            dp = cur;
        }
        int total = 0;
        for (int i = 1; i <= n; ++i) total = (total + dp[i]) % MOD;
        return total;
    }
}

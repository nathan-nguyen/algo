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
            int W = in.nextInt();
            int[] w = new int[n];
            int[] v = new int[n];
            for (int i = 0; i < n; ++i) v[i] = in.nextInt();
            for (int i = 0; i < n; ++i) w[i] = in.nextInt();

            int[] dp = new int[W + 1];
            for (int i = 0; i < n; ++i) {
                for (int j = W; j >= w[i]; --j) {
                    dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
                }
            }

            int max = 0;
            for (int i = 0; i <= W; ++i) max = Math.max(max, dp[i]);
            System.out.println(max);
        }
    }
}

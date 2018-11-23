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
            int[] a = new int[n];
            for (int i = 0; i < n; ++i) a[i] = in.nextInt();
            int[] dp = new int[n];
            int max = 1;
            for (int i = 0; i < n; ++i) {
                dp[i] = 1;
                for (int j = 0; j < i; ++j) {
                    if (a[i] > a[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
            System.out.println(max);
        }
    }
}

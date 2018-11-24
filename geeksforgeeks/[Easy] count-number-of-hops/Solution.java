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
            int[] dp = new int[n+1];
            dp[0] = 1;
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j < 4 && j <= i; ++j) dp[i] += dp[i-j];
            }
            System.out.println(dp[n]);
        }
    }
}

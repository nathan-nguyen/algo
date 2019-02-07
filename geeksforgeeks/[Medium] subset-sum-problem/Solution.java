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
            int total = 0;
            for (int i = 0; i < n; ++i) {
                a[i] = in.nextInt();
                total += a[i];
            }

            if (total % 2 == 1) {
                System.out.println("NO");
                continue;
            }

            total /= 2;
            boolean[] dp = new boolean[total + 1];
            dp[0] = true;
            for (int i = 0; i < n; ++i) {
                for (int j = total; j >= a[i]; --j) dp[j] |= dp[j-a[i]];
            }
            System.out.println(dp[total] ? "YES" : "NO");
        }
    }
}

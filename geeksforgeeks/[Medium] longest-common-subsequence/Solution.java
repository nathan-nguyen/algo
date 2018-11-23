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
            int l1 = in.nextInt();
            int l2 = in.nextInt();
            String s1 = in.next();
            String s2 = in.next();
            System.out.println(solve(s1, s2));
        }
    }

    private int solve(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); ++i) {
            for (int j = 1; j <= s2.length(); ++j) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
            }
        }
        return dp[s1.length()][s2.length()];
    }
}

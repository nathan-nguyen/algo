import java.util.*;

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
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];

        if (s1.charAt(0) == s2.charAt(0)) dp[0][0] = 0;
        else dp[0][0] = 1;
        for (int i = 1; i < n; ++i) dp[i][0] = (s1.charAt(i) == s2.charAt(0) || dp[i-1][0] < i) ? i : i + 1;
        for (int i = 1; i < m; ++i) dp[0][i] = (s1.charAt(0) == s2.charAt(i) || dp[0][i-1] < i) ? i : i + 1;

        for (int  i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                // Delete - Insert
                dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                // Replace - Nothing
                dp[i][j] = Math.min(dp[i][j], (s1.charAt(i) == s2.charAt(j) ? 0 : 1) + dp[i-1][j-1]);
            }
        }
        return dp[n-1][m-1];
    }
}

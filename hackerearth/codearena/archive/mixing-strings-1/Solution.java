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
        String[] a = new String[n];
        for (int i = 0; i < n; ++i) a[i] = in.next();

        // in[i][j] - Append a[j] to end of a[i]
        int[][] inc = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) if (i != j) {
                inc[i][j] = append(a[i], a[j]);
            }
        }

        int[][] dp = new int[1 << n][n];
        for (int i = 0; i < 1 << n; ++i) Arrays.fill(dp[i], Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) dp[1 << i][i] = a[i].length();

        for (int mask = 0; mask < 1 << n; ++mask) {
            for (int i = 0; i < n; ++i) if (((mask >> i) & 1) == 1) {
                for (int j = 0; j < n; ++j) if (((mask >> j) & 1) == 0) {
                    int submask = mask ^ (1 << j);
                    dp[submask][j] = Math.min(dp[submask][j], dp[mask][i] + inc[i][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) min = Math.min(min, dp[(1 << n) - 1][i]);
        System.out.println(min);
    }

    private int append(String s1, String s2) {
        for (int i = Math.min(s1.length(), s2.length()); i >= 0; --i) {
            if (s1.substring(s1.length() - i).equals(s2.substring(0, i))) return s2.length() - i;
        }
        return s2.length();
    }
}

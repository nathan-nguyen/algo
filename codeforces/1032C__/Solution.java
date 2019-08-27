import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) a[i] = in.nextInt();
        int[][] dp = new int[n][6];

        dp[0][1] = dp[0][2] = dp[0][3] = dp[0][4] = dp[0][5] = 1;
        for (int i = 1; i < n; ++i) {
            for (int x = 1; x < 6; ++x) {
                for (int y = 1; y < 6; ++y) {
                    if (dp[i-1][y] == 0) continue;
                    if ((a[i] > a[i-1] && x > y) || (a[i] < a[i-1] && x < y) || (a[i] == a[i-1] && x != y)) {
                        dp[i][x] = y;
                        break;
                    }
                }
            }
        }

        int start = 0;
        for (int i = 1; i < 6; ++i) {
            if (dp[n-1][i] > 0) {
                start = i;
                break;
            }
        }
        
        if (start == 0) {
            System.out.println("-1");
            return;
        }

        for (int i = n - 1; i >= 0; --i) {
            a[i] = start;
            if (i > 0) start = dp[i][start];
        }
        for (int i = 0; i < n; ++i) System.out.print(a[i] + " ");
        System.out.println();
    }
}

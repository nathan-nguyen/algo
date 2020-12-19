import java.util.*;

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

        int[][] dp = new int[n][5];

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < 5; ++j) {
                dp[i][j] = -1;
                for (int k = 0; k < 5; ++k) {
                    if (dp[i-1][k] < 0) continue;
                    if ((a[i-1] < a[i] && k < j) || (a[i-1] > a[i] && k > j) || (a[i-1] == a[i] && k != j)) {
                        dp[i][j] = k;
                        break;
                    }
                }
            }
        }
        int index = 0;
        for (int i = 0; i < 5; ++i) if (dp[n-1][i] >= 0) {
            index = i;
            break;
        }
        if (dp[n-1][index] < 0) {
            System.out.println(-1);
            return;
        }
        List<Integer> list = new ArrayList<>();
        list.add(index);
        for (int i = n - 1; i > 0; --i) {
            list.add(dp[i][index]);
            index = dp[i][index];
        }
        for (int i = n - 1; i >= 0; --i) System.out.print((list.get(i) + 1) + " ");
        System.out.println();
    }
}

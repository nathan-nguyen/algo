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

            System.out.println(solve(n, a));
        }
    }

    private int solve(int n, int[] a) {
        int total = 0;
        for (int i: a) total += i;

        boolean[] dp = new boolean[total+1];
        dp[0] = true;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            for (int j = total; j >= a[i]; --j) dp[j] |= dp[j-a[i]];
        }
        for (int i = 0; i <= total; ++i) {
            if (dp[i]) min = Math.min(min, Math.abs(i * 2 - total));
        }
        return min;
    }
}

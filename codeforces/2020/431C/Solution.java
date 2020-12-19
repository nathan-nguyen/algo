import java.util.Scanner;

public class Solution {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int d = in.nextInt();

        int[] high = new int[n + 1];
        int[] low = new int[n+1];
        low[0] = high[0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int x = 1; x <= k; ++x) {
                if (i >= x) high[i] = (high[i] + high[i-x]) % MOD;
                if (i >= x && x < d) low[i] = (low[i] + low[i-x]) % MOD;
            }
        }

        System.out.println((high[n] - low[n] + MOD) % MOD);
    }
}

import java.util.*;
import java.io.*;

public class Solution {
    private InputReader in = new InputReader(System.in);
 
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    private static int MOD = 1000_000_007;

    private void solve() {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) a[i] = in.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = n; j >= 1; --j) if (a[i] % j == 0) {
                dp[j] = (dp[j] + dp[j-1]) % MOD;
            }
        }
        long total = 0;
        for (int i = 1; i <= n; ++i) total = (total + dp[i]) % MOD;
        System.out.println(total);
    }
}

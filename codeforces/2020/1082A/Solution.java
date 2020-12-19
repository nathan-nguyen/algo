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

    private void solve() {
        int t = in.nextInt();
        while (t -- > 0) {
            long n = in.nextLong() - 1;
            long x = in.nextLong() - 1;
            long y = in.nextLong() - 1;
            long d = in.nextLong();
            System.out.println(solve(n, x, y, d));
        }
    }

    private long solve(long n, long x, long y, long d) {
        if (x % d == y % d) return Math.abs(x - y) / d;
        if (y % d == 0 && y % d == n % d) return Math.min(x / d + 1 + y / d, (n - x) / d + 1 + (n - y) / d);
        if (y % d == 0) return x / d + 1 + y / d;
        if (y % d == n % d) return (n - x) / d + 1 + (n - y) / d;
        return -1;
    }
}

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
        int n = in.nextInt();
        // n - 1
        long[] a = new long[n];
        for (int i = 0; i < n; ++i) a[i] = in.nextLong();

        long total = 0;
        System.out.println(n + 1);
        for (int i = n - 1; i >= 0; --i) {
            long x = ((a[i] + total) / n) * n + i - a[i] - total;
            x = x < 0 ? x + n : x;
            total += x;
            System.out.println(1 + " " + (i+1) + " " + x);
        }
        System.out.println(2 + " " + n + " " + n);
    }
}

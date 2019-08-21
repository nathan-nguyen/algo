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
        long[] a = new long[n];
        for (int i = 0; i < n; ++i) a[i] = in.nextLong();
        System.out.println(solve(n, a));
    }

    private long solve(int n, long[] a) {
        long result = a[0];
        for (int i = 1; i < n; ++i) result = gcd(result, a[i]);
        return divisorCount(result);
    }

    private long gcd(long a, long b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }

    private int divisorCount(long d) {
        int k = (int) (Math.sqrt(d) + 1);
        int count = 0;
        for (int i = 1; i <= k; ++i) {
            if (d % i == 0){
                ++count;
                if (d / i > k) ++count;
            }
        }
        return count;
    }
}

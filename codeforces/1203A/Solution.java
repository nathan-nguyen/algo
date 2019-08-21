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
        int q = in.nextInt();
        while (q -- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; ++i) a[i] = in.nextInt();
            System.out.println(solve(n, a) ? "YES" : "NO");
        }
    }

    private boolean solve(int n, int[] a) {
        return checkClockwise(n, a) || checkAnticlockwise(n, a);
    }

    private boolean checkClockwise(int n, int[] a) {
        for (int i = 0; i < n - 1; ++i) {
            if ((a[i] % n + 1) % n == a[i + 1] % n) continue;
            return false;
        }
        return true;
    }

    private boolean checkAnticlockwise(int n, int[] a) {
        for (int i = 0; i < n - 1; ++i) {
            if ((a[i] % n + n - 1) % n == a[i + 1] % n) continue;
            return false;
        }
        return true;
    }
}

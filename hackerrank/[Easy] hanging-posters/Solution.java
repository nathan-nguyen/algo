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
        int h = in.nextInt();
        int[] w = new int[n];
        int[] p = new int[n];

        for (int i = 0; i < n; ++i) w[i] = in.nextInt();
        for (int i = 0; i < n; ++i) p[i] = in.nextInt();
        int min = 0;
        for (int i = 0; i < n; ++i) {
            min = Math.max(min, Math.max((w[i] - p[i] / 4), h) - h);
        }
        System.out.println(min);
    }
}

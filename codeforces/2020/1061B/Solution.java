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
        int m = in.nextInt();
        int[] a = new int[n];
        long total = 0;
        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
            total += a[i];
        }
        Arrays.sort(a);
        // a[i] > 0
        long count = a[0] - 1;
        for (int i = 1; i < n; ++i) {
            if (a[i] > a[i-1]) count += a[i] - a[i-1] - 1;
            else if (a[i] == a[i-1]) count = Math.max(0, count - 1);
        }

        System.out.println(total - count - n); 
    }
}

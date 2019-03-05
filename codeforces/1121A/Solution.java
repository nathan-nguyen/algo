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
        int k = in.nextInt();
        int[] p = new int[n];
        int[] s = new int[n];
        int[] c = new int[k];

        int[] max = new int[m];

        for (int i = 0; i < n; ++i) p[i] = in.nextInt();
        for (int i = 0; i < n; ++i) {
            s[i] = in.nextInt() - 1;
            max[s[i]] = Math.max(max[s[i]], p[i]);
        }
        int count = 0;
        for (int i = 0; i < k; ++i) {
            int a = in.nextInt() - 1;
            if (max[s[a]] > p[a]) ++count;
        }
        System.out.println(count);
    }
}

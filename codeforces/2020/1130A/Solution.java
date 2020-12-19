import java.util.*;
import java.io.*;

public class Solution {
    private InputReader in = new InputReader(System.in);
 
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve());
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

    private int solve() {
        int n = in.nextInt();
        int pos = 0;
        int neg = 0;
        for (int i = 0; i < n; ++i) {
            int k = in.nextInt();
            if (k < 0) ++neg;
            else if (k > 0) ++pos;
        }
        int x = n % 2 == 0 ? n / 2 : n / 2 + 1;
        if (pos >= x) return 1;
        if (neg >= x) return -1;
        return 0;
    }
}

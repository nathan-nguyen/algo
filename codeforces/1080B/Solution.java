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
        while (q-- > 0) {
            long l = in.nextLong();
            long r = in.nextLong();

           long left = (l % 2 == 1) ? ((l - 1) / 2) : (l / 2 - l);
           long right = (r % 2 == 0) ? (r / 2) : ((r - 1) / 2 - r);
           System.out.println(right - left);
        }
    }
}

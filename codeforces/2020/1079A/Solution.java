import java.util.*;
import java.io.*;

public class Solution {
    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
 
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
        solution.exit();
    }

    private void solve() {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[100];
        int max = 0;
        int count = 0;
        for (int i = 0; i < n; ++i) {
            int x = in.nextInt() - 1;
            if (a[x] == 0) ++count;
            max = Math.max(max, ++a[x]);
        }
        System.out.println(((max % k == 0) ? (max / k) : (max / k + 1)) * k * count - n);
    }

    private void exit() {
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

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
}

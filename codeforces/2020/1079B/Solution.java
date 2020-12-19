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
        String s = in.next();
        int r = s.length() % 20 == 0 ? s.length() / 20 : s.length() / 20 + 1;
        int c = s.length() % r == 0 ? s.length() / r : s.length() / r + 1;
        int x = r * c - s.length();
        int k = x % r;

        int count = 0;
        System.out.println(r + " " + c);
        while (r -- > 0) {
            for (int i = 0; i < c - 1; ++i) System.out.print(s.charAt(count++));
            if (k > 0) {
                --k;
                System.out.print('*');
            } else System.out.print(s.charAt(count++));
            System.out.println();
        }
        System.out.println();
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

import java.util.*;
import java.io.*;

public class TestClass {
    private InputReader in = new InputReader(System.in);
 
    public static void main(String[] args) {
        TestClass solution = new TestClass();
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
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t -- > 0) {
            int n = in.nextInt();
            double total = 0;
            for (int i = 0; i < n; ++i) total += in.nextInt();
            System.out.printf("%.8f\n", total / n);
        }
    }
}

import java.util.*;

public class Solution {
    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.ou);
 
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
        solution.exit();
    }

    private void solve() {
        
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

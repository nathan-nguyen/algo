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

    private boolean debug = false;

    private void solve() {
        int a = 0, b = 0;
        int result = ask(0, 0);
        boolean greater = result > 0;
        int left = 0, right = 0;
        List<Integer> indexList = new ArrayList<>();

        for (int i = 29; i >= 0; --i) {
            int r = ask(left | (1 << i), right | (1 << i));
            if (r == 0) {
                for (int j = 0; j <= i; ++j) indexList.add(j);
                break;
            }
            if (r < 0 && greater) {
                a |= 1 << i;
                left |= 1 << i;
                greater = ask(left, right) > 0;
            }
            else if (r > 0 && !greater) {
                b |= 1 << i;
                right |= 1 << i;
                greater = ask(left, right) > 0;
            }
            else indexList.add(i);
        }
        int x = equal(30, left, right, indexList);
        a = a | x;
        b = b | x;
        System.out.println("! " + a + " " + b);
    }

    private int equal(int n, int left, int right, List<Integer> indexList) {   // n: numbers left
        int a = 0;
        for (int i : indexList) {
            int result = ask(left | (1 << i), right);
            if (result < 0) a |= (1 << i);
        }
        return a;
    }

    private int ask(int c, int d) {
        System.out.println("? " + c + " " + d);
        System.out.flush();
        return in.nextInt();
    }
}

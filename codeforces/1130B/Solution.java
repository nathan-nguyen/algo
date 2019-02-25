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

    private long solve() {
        int n = in.nextInt();
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i <= n; ++i) l.add(new ArrayList<>());
        for (int i = 0; i < 2 * n; ++i) l.get(in.nextInt()).add(i);

        long total = l.get(1).get(0) + l.get(1).get(1);
        for (int i = 2; i <= n; ++i) {
            total += solve(l.get(i-1).get(0), l.get(i-1).get(1), l.get(i).get(0), l.get(i).get(1));
        }
        return total;
    }

    private long solve(int a, int b, int x, int y) {
        return Math.min(Math.abs(a - x) + Math.abs(b - y), Math.abs(a - y) + Math.abs(b - x));
    }
}

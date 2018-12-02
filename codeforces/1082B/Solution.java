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
        String s = in.next();
        System.out.println(solve(n, s));
    }

    private int solve(int n, String s) {
        // Added random character at the end
        s = s + "$";
        List<Integer> list = new ArrayList<>();

        int count = 1;
        int totalGRange = 0;
        int max = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) ++count;
            else {
                if (s.charAt(i - 1) == 'G') {
                    list.add(count);
                    max = Math.max(max, count);
                    ++totalGRange;
                }
                else list.add(-count);
                count = 1;
            }
        }

        if (totalGRange < 2) return max;
        ++max;

        int ans = 0;
        for (int i = 1; i < list.size() - 1; ++i) {
            if (list.get(i) == -1) ans = Math.max(ans, list.get(i - 1) + list.get(i + 1));
        }
        if (totalGRange > 2) ++ans;

        return Math.max(ans, max);
    }
}

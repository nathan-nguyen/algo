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
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) a.add(in.nextInt());
        Collections.sort(a);

        int skip = 0, skipMax = 0;
        int decr = a.get(0) > 1 ? 1 : 0;
        int hold = 1;
        int incr = 1;

        for (int i = 1; i < n; ++i) {
            int newSkip = skip, newSkipMax = skipMax;
            int newDecr = decr;
            int newHold = hold;
            int newIncr = incr;

            // Skip
            if (decr > newSkip || (decr == newSkip && a.get(i-1) - 1 <= newSkipMax)) {
                newSkip = decr;
                newSkipMax = a.get(i-1) - 1;
            }
            if (hold > newSkip || (hold == newSkip && a.get(i-1) <= newSkipMax)) {
                newSkip = hold;
                newSkipMax = a.get(i-1);
            }
            if (incr > newSkip || (incr == newSkip && a.get(i-1) + 1 <= newSkipMax)) {
                newSkip = incr;
                newSkipMax = a.get(i-1) + 1;
            }

            // Decreasing
            if (a.get(i) - 1 > skipMax) newDecr = Math.max(newDecr, skip + 1);
            if (a.get(i) - 1 > a.get(i-1) - 1) newDecr = Math.max(newDecr, decr + 1);
            if (a.get(i) - 1 > a.get(i-1)) newDecr = Math.max(newDecr, hold + 1);
            if (a.get(i) - 1 > a.get(i-1) + 1) newDecr = Math.max(newDecr, incr + 1);

            // Hold
            if (a.get(i) > skipMax) newHold = Math.max(newHold, skip + 1);
            if (a.get(i) > a.get(i-1) - 1) newHold = Math.max(newHold, decr + 1);
            if (a.get(i) > a.get(i-1)) newHold = Math.max(newHold, hold + 1);
            if (a.get(i) > a.get(i-1) + 1) newHold = Math.max(newHold, incr + 1);

            // Increasing
            if (a.get(i) + 1 > skipMax) newIncr = Math.max(newIncr, skip + 1);
            if (a.get(i) + 1 > a.get(i-1) - 1) newIncr = Math.max(newIncr, decr + 1);
            if (a.get(i) + 1 > a.get(i-1)) newIncr = Math.max(newIncr, hold + 1);
            if (a.get(i) + 1 > a.get(i-1) + 1) newIncr = Math.max(newIncr, incr + 1);

            skip = newSkip;
            skipMax = newSkipMax;
            decr = newDecr;
            hold = newHold;
            incr = newIncr;
        }
        System.out.println(Math.max(Math.max(skip, decr), Math.max(hold, incr)));
    }
}

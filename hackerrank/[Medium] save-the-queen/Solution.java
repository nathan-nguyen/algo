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
        int k = in.nextInt();

        List<Long> list = new ArrayList<>();
        long total = 0;
        for (int i = 0; i < k; ++i) {
            list.add(in.nextLong());
            total += list.get(i);
        }

        list.sort((u, v) -> Long.compare(v, u));

        long[] a = new long[n];
        for (int i = n - 1; i >= 0; --i) {
            a[i] = list.get(n - 1 - i);
            total -= a[i];
        }
        
        for (int i = 1; i < n; ++i) {
            if (total < (a[i] - a[i-1]) * i) {
                System.out.println(a[i-1] + total * 1.0 / i);
                return;
            }
            total -= (a[i] - a[i-1]) * i;
        }
        System.out.println(a[n-1] + total * 1.0 / n);
    }
}


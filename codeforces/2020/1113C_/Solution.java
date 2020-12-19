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
        int[] a = new int[n];

        int x = 0;
        Map<Integer, int[]> map = new HashMap<>();
        long result = 0;

        map.put(0, new int[]{0, 1});
        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
            x ^= a[i];
            int[] value = map.getOrDefault(x, new int[]{0, 0});

            result += value[i % 2];
            ++value[i % 2];
            map.put(x, value);
        }
        System.out.println(result);
    }
}

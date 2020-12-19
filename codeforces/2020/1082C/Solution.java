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
        int m = in.nextInt();

        Map<Long, List<Long>> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            long a = in.nextLong();
            long b = in.nextLong();
            List<Long> list = map.getOrDefault(a, new ArrayList<>());
            list.add(b);
            map.put(a, list);
        }

        long[] total = new long[n];

        for (long k: map.keySet()) {
            List<Long> list = map.get(k);
            list.sort((u, v) -> Long.compare(v, u));

            long sum = Math.max(0, list.get(0));
            total[0] += sum;

            for (int i = 1; i < list.size() && sum > 0; ++i) {
                sum = Math.max(0, sum + list.get(i));
                total[i] += sum;
            }
        }

        long max = 0;
        for (int i = 0; i < n; ++i) max = Math.max(max, total[i]);
        System.out.println(max);
    }
}

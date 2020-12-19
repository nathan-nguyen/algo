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
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; ++i) list.add(new ArrayList<>());
        for (int i = 0; i < m; ++i) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            int d = b > a ? b - a : (b + n - a);
            list.get(a).add(d);            
        }

        int[] d = new int[n];
        for (int i = 0; i < n; ++i) {
            if (list.get(i).size() == 0) continue;
            int min = Integer.MAX_VALUE;
            for (int k: list.get(i)) min = Math.min(min, k);
            d[i] = n * (list.get(i).size() - 1) + min;
        }

        for (int i = 0; i < n; ++i) {
            int max = 0;
            for (int x = 0; x < n; ++x) {
                if(d[(i + x) % n] > 0) max = Math.max(max, x + d[(i + x) % n]);
            }
            System.out.print(max + " ");
        }
        System.out.println();
    }
}

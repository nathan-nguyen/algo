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
        while (n -- > 0) {
            int x = in.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            int max = 0;
            for (int i = 0; i < x; ++i) {
                int k = in.nextInt();
                int t = map.getOrDefault(k, 0) + 1;
                max = Math.max(max, t);
                map.put(k, t);
            }
            List<Integer> list = new ArrayList<>();
            for (int k: map.keySet()){
                if (map.get(k) == max) list.add(k);
            }
            Collections.sort(list, (u, v) -> Integer.compare(v, u));
            for (int i: list) System.out.print(i + " ");
            System.out.println();
        }
    }
}

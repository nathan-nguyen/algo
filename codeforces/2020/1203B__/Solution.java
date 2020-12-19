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
        int q = in.nextInt();
        while (q -- > 0) {
            System.out.println(getInputAndSolve() ? "YES" : "NO");
        }
    }

    private boolean getInputAndSolve() {
        int n = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 4 * n; ++i) {
            int k = in.nextInt();
            map.put(k, map.getOrDefault(k, 0) + 1);
        }

        for (int k: map.keySet()) {
            if (map.get(k) % 2 != 0) return false;
        }

        for (int k: map.keySet()) {
            map.put(k, map.get(k) / 2);
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);
        return verify(keyList.get(0) * keyList.get(keyList.size() - 1), map);
    }

    private boolean verify(int area, Map<Integer, Integer> map) {
        for (int k: map.keySet()) {
            if (area % k != 0) return false;
            if (k  * k == area && map.get(k) % 2 != 0) return false;
            if (map.get(k) != map.get(area / k)) return false;
        }
        return true;
    }
}

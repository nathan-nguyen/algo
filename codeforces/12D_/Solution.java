import java.io.*;
import java.util.*;

public class Solution {
    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
 
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
        solution.exit();
    }

    private void solve() {
        int n = in.nextInt();
        int[][] a = new int[n][3];
        int[] c = new int[n];

        for (int i = 0; i < n; ++i) a[i][0] = in.nextInt();
        for (int i = 0; i < n; ++i) {
            a[i][1] = 1000_000_000 - in.nextInt();
            c[i] = a[i][1];
        }
        for (int i = 0; i < n; ++i) a[i][2] = in.nextInt();

        Arrays.sort(a, (u, v) -> Integer.compare(v[0], u[0]));
        Arrays.sort(c);

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(c[0], count++);
        for (int i = 1; i < n; ++i) {
            if (c[i] != c[i-1]) map.put(c[i], count++);
        }

        int[] tree = new int[count + 1];
        int answer = 0;
        for (int i = 0, j = 0; i < n; ++i) {
            a[i][1] = map.get(a[i][1]);
            while (j < n && a[j][0] > a[i][0]) {
                update(tree, count, a[j][1], a[j][2]);
                ++j;
            }

            if (get(tree, a[i][1] - 1) > a[i][2]) ++answer;
        }

        System.out.println(answer);
    }

    private int get(int[] tree, int index) {
        ++index;
        int result = 0;
        while (index > 0) {
            result = Math.max(result, tree[index]);
            index -= index & (-index);
        }
        return result;
    }

    private void update(int[] tree, int n, int index, int value) {
        ++index;
        while (index <= n) {
            tree[index] = Math.max(tree[index], value);
            index += index & (-index);
        }
    }

    private void exit() {
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

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
}

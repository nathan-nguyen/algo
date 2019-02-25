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

    private int solve() {
        int n = in.nextInt();
        int r1 = in.nextInt() - 1;
        int c1 = in.nextInt() - 1;
        int r2 = in.nextInt() - 1;
        int c2 = in.nextInt() - 1;

        String[] g = new String[n];
        for (int i = 0; i < n; ++i) g[i] = in.next();

        int[][] group = new int[n][n];
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (g[i].charAt(j) == '1' || group[i][j] > 0) continue;
                ++count;
                dfs(i, j, n, g, group, count);
            }
        }
        if (group[r1][c1] == group[r2][c2]) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (group[i][j] != group[r1][c1]) continue;
                for (int x = 0; x < n; ++x) {
                    for (int y = 0; y < n; ++y) {
                        if (group[x][y] != group[r2][c2]) continue;
                        min = Math.min(min, (x - i) * (x - i) + (y - j) * (y - j));
                    }
                }
            }
        }

        return min;
    }

    private void dfs(int i, int j, int n, String[] g, int[][] group, int count) {
        if (i < 0 || j < 0 || i >= n || j >= n || g[i].charAt(j) == '1' || group[i][j] > 0) return;
        group[i][j] = count;
        dfs(i, j + 1, n, g, group, count);
        dfs(i + 1, j, n, g, group, count);
        dfs(i, j - 1, n, g, group, count);
        dfs(i - 1, j, n, g, group, count);
    }
}

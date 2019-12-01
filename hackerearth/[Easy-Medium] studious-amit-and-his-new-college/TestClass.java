import java.util.*;
import java.io.*;

public class TestClass {
    private InputReader in = new InputReader(System.in);
 
    public static void main(String[] args) {
        TestClass solution = new TestClass();
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
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t -- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            List<List<Integer>> g = new ArrayList<>();
            for (int i = 0; i < n; ++i) g.add(new ArrayList<>());
            for (int i = 0; i < m; ++i) {
                int u = in.nextInt() - 1;
                int v = in.nextInt() - 1;
                g.get(v).add(u);
            }
            System.out.println(findLoop(g, n) ? 0 : 1);
        }
    }

    private boolean findLoop(List<List<Integer>> g, int n) {
        boolean[] visited = new boolean[n];
        boolean[] set = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                if (findLoop(g, i, visited, set)) return true;
            }
        }
        return false;
    }

    private boolean findLoop(List<List<Integer>> g, int start, boolean[] visited, boolean[] set) {
        if (set[start]) return true;
        if (visited[start]) return false;
        set[start] = true;
        visited[start] = true;
        for (int next: g.get(start)) {
            if (findLoop(g, next, visited, set)) return true;
        }
        set[start] = false;
        return false;
    }
}



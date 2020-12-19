import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private class Graph {
        int vCount = 0;
        List<List<Integer>> v = new ArrayList<>();
        Map<Long, Integer> edge = new HashMap<>();

        public Graph(int n) {
            this.vCount = n;
            for (int i = 0; i < n; ++i) v.add(new ArrayList<>());
        }

        public void addEdge(int x, int y, int c) {
            v.get(x).add(y);
            v.get(y).add(x);
            long key = x < y ? x * 1000_000L + y : y * 1000_000L + x;
            edge.put(key, c);
        }

        public int e(int x, int y) {
            if (x == y) return 0;
            long key = x < y ? x * 1000_000L + y : y * 1000_000L + x;
            return edge.get(key);
        }
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long s = in.nextLong();
            Graph g = new Graph(n);

            for (int i = 0; i < n - 1; ++i) {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                int c = in.nextInt();
                g.addEdge(x, y, c);
            }
            solve(g, s);
        }
    }

    private void solve(Graph g, long s) {
        long[] pel = new long[g.vCount];
        int[] cc = new int[g.vCount];
        boolean[] visited = new boolean[g.vCount];

        dfs(0, 0, g, visited, pel, cc);
        long total = 0;
        for (int i = 0; i < g.vCount; ++i) total += cc[i] * pel[i];
        int count = 0;

        Queue<Integer> queue = new PriorityQueue<>((u, v) -> -Long.compare((pel[u] - pel[u] / 2) * cc[u], (pel[v] - pel[v] / 2) * cc[v]));
        for (int i = 1; i < g.vCount; ++i) queue.offer(i);
        while (total > s) {
            int x = queue.poll();
            total = total - cc[x] * (pel[x] - pel[x] / 2);
            pel[x] = pel[x] / 2;
            queue.offer(x);
            ++count;
        }
        System.out.println(count);
    }

    private void dfs(int p, int i, Graph g, boolean[] visited, long[] pel, int[] cc) {
        if (visited[i]) return;
        visited[i] = true;
        pel[i] = g.e(p, i);

        if (g.v.get(i).size() == 1 && p != i) {
            cc[i] = 1;
            return;
        }

        for (int j: g.v.get(i)) dfs(i, j, g, visited, pel, cc);
        for (int j: g.v.get(i)) if (j != p) cc[i] += cc[j];
    }
}

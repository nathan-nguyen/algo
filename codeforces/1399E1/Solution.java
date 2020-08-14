import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long s = in.nextLong();
            List<List<Integer>> g = new ArrayList<>();
            Map<Long, Integer> e = new HashMap<>();

            for (int i = 0; i < n; ++i) g.add(new ArrayList<>());
            for (int i = 0; i < n - 1; ++i) {
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;
                int x = in.nextInt();
                g.get(a).add(b);
                g.get(b).add(a);
                addEdge(a, b, x, e);
            }
            solve(n, s, g, e);
        }
    }

    private void addEdge(int i, int j, int l, Map<Long, Integer> e) {
        if (i < j) e.put(i * 1000_000L + j, l);
        else e.put(j * 1000_000L + i, l);
    }

    private int getEdgeLength(int i, int j, Map<Long, Integer> e) {
        if (i == j) return 0;
        if (i < j) return e.get(i * 1000_000L + j);
        return e.get(j * 1000_000L + i);
    }

    private void solve(int n, long s, List<List<Integer>> g, Map<Long, Integer> e) {
        long[] pel = new long[n];
        int[] cc = new int[n];
        boolean[] visited = new boolean[n];
        dfs(0, 0, g, e, visited, pel, cc);
        long total = 0;
        for (int i = 0; i < n; ++i) total += cc[i] * pel[i];
        int count = 0;
        Queue<Integer> queue = new PriorityQueue<>((u, v) -> -Long.compare((pel[u] - pel[u] / 2) * cc[u], (pel[v] - pel[v] / 2) * cc[v]));
        for (int i = 1; i < n; ++i) queue.offer(i);
        while (total > s) {
            int x = queue.poll();
            total = total - cc[x] * (pel[x] - pel[x] / 2);
            pel[x] = pel[x] / 2;
            queue.offer(x);
            ++count;
        }
        System.out.println(count);
    }

    private void dfs(int p, int i, List<List<Integer>> g, Map<Long, Integer> e, boolean[] visited, long[] pel, int[] cc) {
        if (visited[i]) return;
        visited[i] = true;
        pel[i] = getEdgeLength(p, i, e);
        if (g.get(i).size() == 1 && i != p) {
            cc[i] = 1;
            return;
        }
        for (int j: g.get(i)) if (j != p) dfs(i, j, g, e, visited, pel, cc);
        for (int j: g.get(i)) if (j != p) cc[i] += cc[j];
    }
}

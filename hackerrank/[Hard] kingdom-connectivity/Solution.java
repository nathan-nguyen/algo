import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        List<List<Integer>> edge = new ArrayList<>();
        List<List<Integer>> reverseEdge = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            edge.add(new ArrayList<>());
            reverseEdge.add(new ArrayList<>());
        }

        for (int i = 0; i < m; ++i) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            edge.get(a).add(b);
            reverseEdge.get(b).add(a);
        }

        boolean[] reachable = new boolean[n];
        updateReachable(n-1, reachable, reverseEdge);

        // Find loop
        boolean[] visited = new boolean[n];
        if (containLoop(new HashSet<>(), 0, visited, edge, reachable)) {
            System.out.println("INFINITE PATHS");
            return;
        }

        int[] value = new int[n];
        Arrays.fill(value, -1);
        System.out.println(dfs(0, value, edge, n-1, reachable));
    }

    private void updateReachable(int cur, boolean[] reachable, List<List<Integer>> edge) {
        if (reachable[cur]) return;
        reachable[cur] = true;
        for (int next: edge.get(cur)) updateReachable(next, reachable, edge);
    }

    private int dfs(int cur, int[] value, List<List<Integer>> edge, int target, boolean[] reachable) {
        if (value[cur] >= 0) return value[cur];
        if (!reachable[cur]) return 0;
        value[cur] = 0;
        if (cur == target) {
            value[cur] = 1;
            return value[cur];
        }
        for (int next: edge.get(cur)) value[cur] = (value[cur] + dfs(next, value, edge, target, reachable)) % 1000_000_000;
        return value[cur];
    }

    private boolean containLoop(Set<Integer> set, int cur, boolean[] visited, List<List<Integer>> edge, boolean[] reachable) {
        if (visited[cur] && set.contains(cur)) return true;
        if (visited[cur] || !reachable[cur]) return false;
        visited[cur] = true;
        set.add(cur);
        for (int next: edge.get(cur)) {
            if (containLoop(set, next, visited, edge, reachable)) return true;
        }
        set.remove(cur);
        return false;
    }
}

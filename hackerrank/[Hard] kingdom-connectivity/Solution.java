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

        // Check whether there is path from node i to n-1
        boolean[] reachable = new boolean[n];
        updateReachable(n-1, reachable, reverseEdge);


        // Remove unreachable nodes
        for (int i = 0; i < n; ++i) {
            List<Integer> list = new ArrayList<>();
            for (int j: edge.get(i)) if (reachable[j]) list.add(j);
            edge.set(i, list);
        }

        // Find loop from node 0
        boolean[] visited = new boolean[n];
        if (containLoop(new HashSet<>(), 0, visited, edge)) {
            System.out.println("INFINITE PATHS");
            return;
        }

        int[] value = new int[n];
        Arrays.fill(value, -1);
        System.out.println(dfs(0, value, edge, n-1));
    }

    private void updateReachable(int cur, boolean[] reachable, List<List<Integer>> edge) {
        if (reachable[cur]) return;
        reachable[cur] = true;
        for (int next: edge.get(cur)) updateReachable(next, reachable, edge);
    }

    private int dfs(int cur, int[] value, List<List<Integer>> edge, int target) {
        if (value[cur] >= 0) return value[cur];
        value[cur] = 0;
        if (cur == target) value[cur] = 1;
        else for (int next: edge.get(cur)) value[cur] = (value[cur] + dfs(next, value, edge, target)) % 1000_000_000;
        return value[cur];
    }

    private boolean containLoop(Set<Integer> set, int cur, boolean[] visited, List<List<Integer>> edge) {
        if (visited[cur] && set.contains(cur)) return true;
        if (visited[cur]) return false;
        visited[cur] = true;
        set.add(cur);
        for (int next: edge.get(cur)) {
            if (containLoop(set, next, visited, edge)) return true;
        }
        set.remove(cur);
        return false;
    }
}

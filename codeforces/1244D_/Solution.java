import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve());
    }

    private String solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] cost = new int[3][n];

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; ++i) g.add(new ArrayList<>());

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < n; ++j) cost[i][j] = in.nextInt();
        }

        int[] degree = new int[n];
        int[] color = new int[n];
        int[] min = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n - 1; ++i) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            g.get(a).add(b);
            g.get(b).add(a);
            ++degree[a];
            ++degree[b];
        }

        for (int i = 0; i < n; ++i) if (degree[i] > 2) return "-1";

        List<Integer> order = new ArrayList<>();

        boolean[] visited = new boolean[n];
        findOrder(g, 0, visited, order);

        dfs(g, 0, color, min, cost, order);

        StringBuilder result = new StringBuilder();
        long total = 0;
        for (int i = 0; i < n; ++i) total += cost[min[i]][i];

        result.append(total + "\n");
        for (int i = 0; i < n; ++i) result.append((min[i] + 1) + " ");

        return result.toString();
    }

    private void compare(int[] min, int[] color, int[][] cost) {
        long totalMin = 0, total = 0;
        for (int i = 0; i < min.length; ++i) {
            totalMin += cost[min[i]][i];
            total += cost[color[i]][i];
        }
        if (total < totalMin) {
            for (int i = 0; i < min.length; ++i) min[i] = color[i];
        }
    }

    private void dfs(List<List<Integer>> g, int current, int[] color, int[] min, int[][] cost, List<Integer> order) {
        if (current == g.size()) {
            compare(min, color, cost);
            return;
        }

        int node = order.get(current);
        for (int i = 0; i < 3; ++i) {
            if (isValidColor(i, g, node, color)) {
                color[node] = i;
                dfs(g, current + 1, color, min, cost, order);
            }
            color[node] = -1;
        }
    }

    private void findOrder(List<List<Integer>> g, int node, boolean[] visited, List<Integer> order) {
        if (visited[node]) return;
        visited[node] = true;
        order.add(node);
        for (int k: g.get(node)) findOrder(g, k, visited, order);
    }

    private boolean isValidColor(int c, List<List<Integer>> g, int node, int[] color) {
        if (color[node] == c) return false;
        for (int k: g.get(node)) {
            if (color[k] == c) return false;
            for (int x: g.get(k)) {
                if (color[x] == c) return false;
            }
        }
        return true;
    }

}

import java.util.*;

class Solution {
    public static void main(String args[] ) throws Exception {
        Solution solution = new Solution();
        solution.solve();
    }
    
    private void solve() {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        while (T -- > 0) {
            int n = in.nextInt();
            int F = in.nextInt();
            int S = in.nextInt();
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; ++i) graph.add(new ArrayList<>());

            boolean[] visited = new boolean[n];
            for (int i = 0; i < F; ++i) {
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;
                graph.get(a).add(b);
            }

            while (S -- > 0) dfs(in.nextInt() - 1, visited, graph);

            int count = 0;
            for (int i = 0; i < n; ++i) if (visited[i]) ++count;
            System.out.println(count);
        }
    }

    private void dfs(int current, boolean[] visited, List<List<Integer>> graph) {
        if (visited[current]) return;
        visited[current] = true;

        for (int next: graph.get(current)) dfs(next, visited, graph);
    }
}


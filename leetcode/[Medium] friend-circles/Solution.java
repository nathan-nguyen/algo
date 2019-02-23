class Solution {
    public int findCircleNum(int[][] m) {
        int n = m.length;
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; ++i) g.add(new ArrayList<>());
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (m[i][j] == 1) {
                    g.get(i).add(j);
                    g.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (visited[i]) continue;
            dfs(i, g, visited);
            ++count;
        }
        return count;
    }

    private void dfs(int i, List<List<Integer>> g, boolean[] visited) {
        if (visited[i]) return;
        visited[i] = true;
        for (int k: g.get(i)) dfs(k, g, visited);
    }
}

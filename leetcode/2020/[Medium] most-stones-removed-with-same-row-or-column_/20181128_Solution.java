class Solution {
    public int removeStones(int[][] s) {
        int n = s.length;

        List<List<Integer>> edge = new ArrayList<>();
        for (int i = 0; i < n; ++i) edge.add(new ArrayList<>());

        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            if (xMap.containsKey(s[i][0])) {
                int k = xMap.get(s[i][0]);
                edge.get(k).add(i);
                edge.get(i).add(k);
            } 
            if (yMap.containsKey(s[i][1])) {
                int k = yMap.get(s[i][1]);
                edge.get(k).add(i);
                edge.get(i).add(k);
            }
            xMap.put(s[i][0], i);
            yMap.put(s[i][1], i);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (visited[i]) continue;
            ++count;
            dfs(i, edge, visited);
        }
        return n - count;
    }

    private void dfs(int i, List<List<Integer>> edge, boolean[] visited) {
        if (visited[i]) return;
        visited[i] = true;
        for (int k: edge.get(i)) dfs(k, edge, visited);
    }
}

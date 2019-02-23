class Solution {
    public int removeStones(int[][] s) {
        int n = s.length;
        List<List<Integer>> g = new ArrayList<>();
        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            g.add(new ArrayList<>());
            int x = s[i][0];
            int y = s[i][1];

            if (xMap.containsKey(x)) {
                int k = xMap.get(x);
                g.get(i).add(k);
                g.get(k).add(i);
            }
            if (yMap.containsKey(y)) {
                int k = yMap.get(y);
                g.get(i).add(k);
                g.get(k).add(i);
            }
            xMap.put(x, i);
            yMap.put(y, i);
        }

        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (visited[i]) continue;
            ++count;
            dfs(i, g, visited);
        }
        return n - count;
    }

    private void dfs(int i, List<List<Integer>> g, boolean[] visited) {
        if (visited[i]) return;
        visited[i] = true;
        for (int k: g.get(i)) dfs(k, g, visited);
    }
}


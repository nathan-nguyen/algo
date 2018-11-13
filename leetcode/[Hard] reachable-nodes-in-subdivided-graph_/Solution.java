class Solution {
    public int reachableNodes(int[][] edges, int m, int n) {
        // Construct edge list
        List<List<Integer>> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; ++i) list.add(new ArrayList<>());

        for (int[] e: edges) {
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
            map.put(e[0] + "_" + e[1], e[2]);
            map.put(e[1] + "_" + e[0], e[2]);
        }

        // Count step from node 0
        boolean[] visited = new boolean[n];
        int[] count = new int[n];
        Arrays.fill(count, Integer.MAX_VALUE);

        // Using Dijkstra
        TreeSet<Integer> set = new TreeSet<>((u, v) -> (count[u] == count[v]) ? Integer.compare(u, v) : Integer.compare(count[u], count[v]));
        set.add(0);

        count[0] = 0;
        int result = 0;
        while (!set.isEmpty()) {
            int k = set.pollFirst();
            visited[k] = true;
            for (int i: list.get(k)) {
                if (visited[i]) continue;
                int el = map.get(k + "_" + i);
                if (count[k] + el + 1 <  count[i]) {
                    set.remove(i);
                    count[i] = count[k] + el + 1;
                    set.add(i);
                }
            }
            if (count[k] <= m) ++result;
        }
        for (int[] e: edges) {
            result += Math.min(Math.max(m - count[e[0]], 0) + Math.max(m - count[e[1]], 0), e[2]);
        }
        return result;
    }
}


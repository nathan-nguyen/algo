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
        Queue<int[]> queue = new PriorityQueue<>((u, v) -> Integer.compare(u[1], v[1]));
        count[0] = 0;
        queue.add(new int[]{0, count[0]});

        int result = 0;
        while (!queue.isEmpty()) {
            int[] e = queue.poll();
            int current = e[0];

            if (visited[current]) continue;

            count[current] = e[1];
            visited[current] = true;

            for (int i: list.get(current)) {
                if (visited[i]) continue;
                int el = map.get(current + "_" + i);
                if (count[current] + el + 1 <  count[i]) {
                    count[i] = count[current] + el + 1;
                    queue.add(new int[]{i, count[i]});
                }
            }

            if (count[current] <= m) ++result;
        }

        for (int[] e: edges) {
            result += Math.min(Math.max(m - count[e[0]], 0) + Math.max(m - count[e[1]], 0), e[2]);
        }
        return result;
    }
}


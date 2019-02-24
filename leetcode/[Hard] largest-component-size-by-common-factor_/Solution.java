class Solution {
    public int largestComponentSize(int[] a) {
        int n = a.length;
        Arrays.sort(a);

        Map<Integer, Integer> iMap = new HashMap<>();
        List<List<Integer>> g = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; ++i) {
            iMap.put(a[i], i);
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < n; ++i) {
            int k = a[i];
            for (int d = 2; d * d <= k; ++d) {
                if (k % d == 0) {
                    if (map.containsKey(d)) {
                        int y = map.get(d);
                        g.get(i).add(y);
                        g.get(y).add(i);
                    }
                    else map.put(d, i);
                }
                while (k % d == 0) k /= d;
            }
            if (k > 1 && map.containsKey(k)) {
                int y = map.get(k);
                g.get(i).add(y);
                g.get(y).add(i);
            }
            else map.put(k, i);
        }

        int max = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; ++i) max = Math.max(max, dfs(i, g, visited));
        return max;
    }
    
    private int dfs(int i, List<List<Integer>> g, boolean[] visited) {
        if (visited[i]) return 0;
        visited[i] = true;
        int total = 1;
        for (int k: g.get(i)) total += dfs(k, g, visited);
        return total;
    }
}


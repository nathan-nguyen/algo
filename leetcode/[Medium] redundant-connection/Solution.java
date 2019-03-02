class Solution {
    public int[] findRedundantConnection(int[][] e) {
        int n = 0;
        for (int[] k: e) n = Math.max(Math.max(n, k[0]), k[1]);
        ++n;

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; ++i) g.add(new ArrayList<>());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < e.length; ++i) {
            int[] k = e[i];
            g.get(k[0]).add(k[1]);
            g.get(k[1]).add(k[0]);
            map.put(k[0] + "_" + k[1], i);
            map.put(k[1] + "_" + k[0], i);
        }

        boolean[] visited = new boolean[n];
        for (int i = 1; i < n; ++i) {
            if (g.get(i).size() != 0) {
                int[] result = dfs(-1, i, g, visited, map, new Stack<>());
                return new int[]{Math.min(result[0], result[1]), Math.max(result[1], result[0])};
            }
        }
        throw new AssertionError();
    }

    private int[] dfs(int par, int i, List<List<Integer>> g, boolean[] visited, HashMap<String, Integer> map, Stack<Integer> stack) {
        if (visited[i]) {
            int[] result = new int[]{par, i};
            int prev = i;
            while (stack.peek() != i) {
                int cur = stack.pop();
                if (map.get(prev + "_" + cur) > map.get(result[0] + "_" + result[1])) {
                    result[0] = prev;
                    result[1] = cur;
                }
                prev = cur;
            }
            return result;
        }

        visited[i] = true;
        stack.push(i);
        for (int k: g.get(i)) if (k != par) {
            int[] result = dfs(i, k, g, visited, map, stack);
            if (result != null) return result;
        }
        stack.pop();
        return null;
    }
}

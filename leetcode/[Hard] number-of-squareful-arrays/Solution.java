class Solution {
    public int numSquarefulPerms(int[] a) {
        int n = a.length;
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; ++i) g.add(new ArrayList<>());

        java.util.Arrays.sort(a);
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int x = (int) Math.sqrt(a[i] + a[j]);
                if (x * x == a[i] + a[j]) {
                    g.get(i).add(j);
                    g.get(j).add(i);
                }
            }
        }

        int visited = 0;
        int result = 0;
        for (int i = 0; i < n; ++i) {
            if (i == 0 || a[i] > a[i-1]) result += dfs(i, visited, g, a, n);
        }
        return result;
    }

    private int dfs(int i, int visited, List<List<Integer>> g, int[] a, int n) {
        if (((visited >> i) & 1) == 1) return 0;

        visited = visited ^ (1 << i);
        if (visited == (1 << n) - 1) {
            visited = visited ^ (1 << i);
            return 1;
        }

        int min = -1;
        int result = 0;
        for (int k: g.get(i)) {
            if (a[k] <= min) continue;
            if (((visited >> k) & 1) == 0) min = a[k];
            result += dfs(k, visited, g, a, n);
        }
        visited = visited ^ (1 << i);
        return result;
    }
}

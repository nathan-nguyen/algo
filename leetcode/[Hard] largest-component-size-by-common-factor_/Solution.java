class Solution {
    public int largestComponentSize(int[] a) {
        int n = a.length;
        int[] sz = new int[n];
        int[] pr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            sz[i] = 1;
            pr[i] = i;
        }

        for (int i = 0; i < n; ++i) {
            int k = a[i];
            for (int d = 2; d * d <= k; ++d) {
                if (k % d == 0) connect(i, map, sz, pr, d);
                while (k % d == 0) k /= d;
            }
            if (k > 1) connect(i, map, sz, pr, k);
        }

        int max = 0;
        for (int i: sz) max = Math.max(max, i);
        return max;
    }

    private void connect(int i, Map<Integer, Integer> map, int[] sz, int[] pr, int p) {
        if (map.containsKey(p)) connect(i, map.get(p), sz, pr);
        map.put(p, i);
    }

    private void connect(int i, int j, int[] sz, int[] pr) {
        while (i != pr[i]) i = pr[i];
        while (j != pr[j]) j = pr[j];
        if (i == j) return;
        if (sz[i] >= sz[j]) {
            pr[j] = i;
            sz[i] += sz[j];
        } else {
            pr[i] = j;
            sz[j] += sz[i];
        }
    }
}

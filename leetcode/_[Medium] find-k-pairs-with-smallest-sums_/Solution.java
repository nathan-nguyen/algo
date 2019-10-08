class Solution {
    public List<List<Integer>> kSmallestPairs(int[] a, int[] b, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (a.length == 0 || b.length == 0) return result;

        int n = a.length;
        int m = b.length;
        Queue<int[]> pq = new PriorityQueue<>((u, v) -> Integer.compare(a[u[0]] + b[u[1]], a[v[0]] + b[v[1]]));
        for (int i = 0; i < n; ++i) pq.offer(new int[]{i, 0});

        k = Math.min(k, m * n);
        while (k-- > 0) {
            int[] e = pq.poll();
            addPair(result, a[e[0]], b[e[1]]);
            if (e[1] + 1 < m) pq.offer(new int[]{e[0], e[1] + 1});
        }
        return result;
    }

    private void addPair(List<List<Integer>> list, int a, int b) {
        List<Integer> pair = new ArrayList<>();
        pair.add(a);    pair.add(b);
        list.add(pair);
    }
}

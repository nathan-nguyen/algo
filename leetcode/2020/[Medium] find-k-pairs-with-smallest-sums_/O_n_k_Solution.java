class Solution {
    public List<List<Integer>> kSmallestPairs(int[] a, int[] b, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (a.length == 0 || b.length == 0) return result;
        int n = a.length;
        int m = b.length;
        // Suppose that k >= n * m
        int[] current = new int[n];

        k = Math.min(k, m * n);
        while (k-- > 0) {
            long min = Long.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < n; ++i) {
                if (current[i] >= m) continue;
                if (a[i] + b[current[i]] < min) {
                    index = i;
                    min = a[i] + b[current[i]];
                }
            }
            addPair(result, a[index], b[current[index]++]);
        }
        return result;
    }

    private void addPair(List<List<Integer>> list, int a, int b) {
        List<Integer> pair = new ArrayList<>();
        pair.add(a);    pair.add(b);
        list.add(pair);
    }
}

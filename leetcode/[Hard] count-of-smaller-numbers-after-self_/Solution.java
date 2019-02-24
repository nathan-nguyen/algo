class Solution {
    public List<Integer> countSmaller(int[] a) {
        List<Integer> result = new ArrayList<>();
        if (a.length == 0) return result;
        int n = a.length;

        int[] si = new int[n];
        for (int i = 0; i < n; ++i) si[i] = a[i];
        Arrays.sort(si);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) map.put(si[i], i);

        int[] tree = new int[n+1];
        for (int i = n - 1; i >= 0; --i) {
            int index = map.get(a[i]);
            result.add(get(n, tree, index - 1));
            update(n, tree, index);
        }
        Collections.reverse(result);
        return result;
    }

    private void update(int n, int[] tree, int index) {
        ++index;
        while (index <= n) {
            ++tree[index];
            index += index & (-index);
        }
    }

    private int get(int n, int[] tree, int index) {
        ++index;
        int result = 0;
        while (index > 0) {
            result += tree[index];
            index -= index & (-index);
        }
        return result;
    }
}

class Solution {
    public int maxWidthRamp(int[] a) {
        if (a.length == 0) return 0;
        int n = a.length;

        Integer[] b = new Integer[n];
        for (int i = 0; i < n; ++i) b[i] = i;
        Arrays.sort(b, (u, v) -> Integer.compare(a[u], a[v]));
        int max = 0;
        int min = b[0];
        for (int i = 0; i < n; ++i) {
            min = Math.min(min, b[i]);
            max = Math.max(max, b[i] - min);
        }
        return max;
    }
}

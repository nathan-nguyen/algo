class Solution {
    public int maximumSum(int[] a) {
        int n = a.length;
        int[] l = new int[n], r = new int[n];
        int max = Integer.MIN_VALUE;

        int minSum = 0, total = 0;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, a[i]);
            total += a[i];
            minSum = Math.min(minSum, total);
            l[i] = total - minSum;
        }

        minSum = 0; total = 0;
        for (int i = n - 1; i >= 0; --i) {
            total += a[i];
            minSum = Math.min(minSum, total);
            r[i] = total - minSum;
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (i == 0 ? 0 : l[i-1]) + (i == n - 1 ? 0 : r[i+1]) + (a[i] > 0 ? a[i] : 0));
        }
        if (ans == 0) return max;
        return ans;
    }
}

class Solution {
    private static final long MOD = 1000_000_007;

    public int maxSumMinProduct(int[] a) {
        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && a[stack.peek()] > a[i]) right[stack.pop()] = i - 1;
            stack.push(i);
        }
        while (!stack.isEmpty()) right[stack.pop()] = n - 1;

        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && a[stack.peek()] > a[i]) left[stack.pop()] = i + 1;
            stack.push(i);
        }
        while (!stack.isEmpty()) left[stack.pop()] = 0;

        long sum[] = new long[n + 1];
        for (int i = 1; i <= n; ++i) sum[i] = sum[i - 1] + a[i - 1];

        long max = 0;
        for (int i = 0; i < n; ++i) max = Math.max(max, a[i] * (sum[right[i] + 1] - sum[left[i]]));

        return (int)(max % MOD);
    }
}

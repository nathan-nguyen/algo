class Solution {
    public int tallestBillboard(int[] a) {
        int n = a.length;
        int sum = 0;
        for (int i: a) sum += i;

        int[] dpOne = new int[sum * 2 + 1];
        int[] dpTwo = new int[sum * 2 + 1];

        // -sum - 0 - sum
        // 0 - sum - 2 * sum
        Arrays.fill(dpOne, Integer.MIN_VALUE);
        dpOne[sum] = 0;

        for (int i = 0; i < n; ++i) {
            Arrays.fill(dpTwo, Integer.MIN_VALUE);
            for (int j = 0; j < 2 * sum + 1; ++j) {
                if (j >= a[i]) dpTwo[j] = Math.max(dpOne[j], dpOne[j - a[i]] >= 0 ? dpOne[j-a[i]] + a[i] : Integer.MIN_VALUE);
                if (j + a[i] < 2 * sum + 1) dpTwo[j] = Math.max(dpTwo[j], Math.max(dpOne[j], dpOne[j + a[i]]));
            }
            int[] dpTmp = dpOne;
            dpOne = dpTwo;
            dpTwo = dpTmp;
        }
        return dpOne[sum];
    }
}

class Solution {
    public int wiggleMaxLength(int[] a) {
        if (a.length == 0) return 0;
        int n = a.length;

        // 0 - hold, 1 - down, 2 - up
        int mode = 0, count = 1, prev = a[0];
        for (int i = 1; i < n; ++i) {
            if (prev == a[i]) continue;
            if (a[i] > prev && mode != 2) {
                ++count;
                mode = 2;
            }
            else if (a[i] < prev && mode != 1) {
                ++count;
                mode = 1;
            }
            prev = a[i];
        }
        return count;
    }
}

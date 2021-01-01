class Solution {
    public int firstMissingPositive(int[] a) {
        if (a.length == 0) return 1;
        int n = a.length;

        for (int i = 0; i < n; ++i) a[i] -= 1;
        for (int i = 0; i < n;) {
            int pos = a[i];
            if (0 <= pos && pos < n && pos != a[pos]) {
                a[i] ^= a[pos];
                a[pos] ^= a[i];
                a[i] ^= a[pos];
                continue;
            }
            ++i;
        }

        for (int i = 0; i < n; ++i) if (a[i] != i) return i + 1;
        return n + 1;
    }
}


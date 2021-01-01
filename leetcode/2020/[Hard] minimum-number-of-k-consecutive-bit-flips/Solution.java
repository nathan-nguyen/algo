class Solution {
    public int minKBitFlips(int[] a, int k) {
        int n = a.length;
        int[] s = new int[n+1];
        int total = 0, count = 0;
        for (int i = 0; i < n; ++i) {
            total += s[i];
            if (a[i] != total % 2) continue;
            if (i + k > n) return -1;
            ++s[i];
            ++total;
            ++count;
            --s[i+k];
        }
        return count;
    }
}

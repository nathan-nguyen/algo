class Solution {
    public int maxDistance(int[] a, int[] b) {
        int i = 0, j = 0, max = 0;
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) ++i;
            else {
                max = Math.max(max, j - i);
                ++j;
            }
        }
        return max;
    }
}

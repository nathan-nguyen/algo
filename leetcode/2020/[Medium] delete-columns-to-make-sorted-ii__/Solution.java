class Solution {
    public int minDeletionSize(String[] a) {
        int n = a.length;
        int m = a[0].length();

        boolean[] next = new boolean[n-1];
        int count = 0;
        outer:for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n - 1; ++j) {
                if (next[j]) continue;
                if (a[j].charAt(i) > a[j+1].charAt(i)) {
                    ++count;
                    continue outer;
                }
            }
            for (int j = 0; j < n - 1; ++j) {
                if (!next[j] && a[j].charAt(i) != a[j+1].charAt(i)) next[j] = true;
            }
        }
        return count;
    }
}

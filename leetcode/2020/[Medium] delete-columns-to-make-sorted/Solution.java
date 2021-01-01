class Solution {
    public int minDeletionSize(String[] a) {
        int n = a.length;
        int m = a[0].length();

        int count = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (a[j].charAt(i) < a[j-1].charAt(i)) {
                    ++count;
                    break;
                }
            }
        }
        return count;
    }
}


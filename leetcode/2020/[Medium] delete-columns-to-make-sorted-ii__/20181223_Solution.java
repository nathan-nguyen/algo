class Solution {
    public int minDeletionSize(String[] a) {
        int n = a.length;
        int m = a[0].length();

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0, n - 1});

        int count = 0;
        outer:for (int i = 0; i < m; ++i) {
            for (int[] e: list) {
                for (int j = e[0]; j < e[1]; ++j) if (a[j].charAt(i) > a[j+1].charAt(i)) {
                    ++count;
                    continue outer;
                }
            }

            List<int[]> next = new ArrayList<>();
            for (int[] e: list) {
                for (int j = e[0] + 1; j <= e[1]; ++j) if (a[j].charAt(i) == a[j-1].charAt(i)) {
                    int start = j-1;
                    while (j <= e[1] && a[j].charAt(i) == a[j-1].charAt(i)) ++j;
                    next.add(new int[]{start, j - 1});
                }
            }
            if (next.size() == 0) return count;
            list = next; 
        }
        return count;
    }
}

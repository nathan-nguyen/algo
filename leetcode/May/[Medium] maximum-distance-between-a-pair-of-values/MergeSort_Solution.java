class Solution {
    public int maxDistance(int[] a1, int[] a2) {
        int n = a1.length;
        int m = a2.length;
        int[][] a = new int[n + m][3];

        for (int i = 0; i < n + m; ++i) {
            if (i < m) {
                a[i][0] = a2[i];
                a[i][1] = 1;
                a[i][2] = i;
            }
            else {
                a[i][0] = a1[i - m];
                a[i][1] = 0;
                a[i][2] = i - m;
            }
        }

        return mergeSort(a, 0, n + m - 1);
    }

    private void updateResult(int[] a, int[] result) {
        if (a[1] == 0) result[1] = Math.min(result[1], a[2]);
        else result[0] = Math.max(result[0], a[2] - result[1]);
    }

    private int mergeSort(int[][] a, int s, int e) {
        if (s == e) return 0;

        int m = (s + e) / 2;

        int[] result = new int[2];
        result[0] = Math.max(result[0], mergeSort(a, s, m));
        result[0] = Math.max(result[0], mergeSort(a, m + 1, e));

        int l = s, r = m + 1;
        int[][] tmp = new int[e - s + 1][3];
        int count = 0;

        result[1] = Integer.MAX_VALUE;
        while (l <= m && r <= e) {
            if (a[l][0] < a[r][0] || (a[l][0] == a[r][0] && a[l][1] < a[r][1])) {
                updateResult(a[l], result);
                tmp[count++] = a[l++];
            }
            else {
                updateResult(a[r], result);
                tmp[count++] = a[r++];
            }
        }

        while (l <= m) {
            updateResult(a[l], result);
            tmp[count++] = a[l++];
        }

        while (r <= e) {
            updateResult(a[r], result);
            tmp[count++] = a[r++];
        }

        for (int i = 0; i < count; ++i) a[s + i] = tmp[i];
        return result[0];
    }
}

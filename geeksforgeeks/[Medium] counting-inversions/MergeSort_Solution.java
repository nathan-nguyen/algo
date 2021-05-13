class Solution {
    private static long mergeSort(long[] a, int s, int e) {
        if (s == e) return 0;

        int mid = (s + e) / 2;
        long inversionCount = 0;
        inversionCount += mergeSort(a, s, mid);
        inversionCount += mergeSort(a, mid + 1, e);

        long[] buffer = new long[e - s + 1];
        int l = s, r = mid + 1, count = 0;

        while (l <= mid && r <= e) {
            if (a[l] <= a[r]) buffer[count++] = a[l++];
            else {
                inversionCount += (mid - l + 1);
                buffer[count++] = a[r++];
            }
        }

        while (l <= mid) buffer[count++] = a[l++];
        while (r <= e) buffer[count++] = a[r++];
        
        for (int i = 0; i < count; ++i) a[s+i] = buffer[i];

        StringBuilder sb = new StringBuilder();
        for (int i = s; i <= e; ++i) sb.append(a[i]).append(" ");
        sb.append(" - ").append(inversionCount);
        System.out.println(sb);


        return inversionCount;
    }

    static long inversionCount(long a[], long n) {
        return mergeSort(a, 0, (int) n - 1);
    }
}

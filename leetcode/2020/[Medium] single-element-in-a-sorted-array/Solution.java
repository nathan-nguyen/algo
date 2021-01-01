class Solution {
    public int singleNonDuplicate(int[] a) {
        return singleNonDuplicate(a, 0, a.length - 1);
    }

    private int singleNonDuplicate(int[] a, int start, int end) {
        if (start == end) return a[start];

        if ((end - start + 1) % 2 == 0) return 0;
        int mid = (start + end) / 2;
        if (a[mid] == a[mid - 1]) return singleNonDuplicate(a, start, mid - 2) + singleNonDuplicate(a, mid + 1, end);
        if (a[mid] == a[mid + 1]) return singleNonDuplicate(a, start, mid - 1) + singleNonDuplicate(a, mid + 2, end);
        return a[mid];
    }
}


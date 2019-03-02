class Solution {
    public int findMin(int[] a) {
        return findMin(a, 0, a.length - 1);
    }

    private int findMin(int[] a, int start, int end) {
        if (a[start] < a[end]) return a[start];

        if (start + 1 >= end) return Math.min(a[start], a[end]);
        int mid = (start + end) / 2;
        if (a[start] == a[end]) return Math.min(findMin(a, start, mid), findMin(a, mid + 1, end));

        if (a[start] <= a[mid]) return findMin(a, mid, end);
        return findMin(a, start, mid);
    }
}

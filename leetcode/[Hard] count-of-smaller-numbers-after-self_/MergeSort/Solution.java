class Solution {
    private int[] result;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] a = new int[n];

        for (int i = 0; i < n; ++i) a[i] = i;
        result = new int[n];
        mergeSort(a, nums, 0, n - 1);
        List<Integer> list = new ArrayList<>();
        for (int k: result) list.add(k);
        return list;
    }

    private void mergeSort(int[] a, int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(a, nums, start, mid);
        mergeSort(a, nums, mid + 1, end);
        merge(a, nums, start, end);
    }

    private void merge(int[] a, int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        int l = start;
        int r = mid + 1;
        int[] tmp = new int[end - start + 1];
        int count = 0;
        int countRight = 0;

        while (l <= mid && r <= end) {
            if (nums[a[l]] <= nums[a[r]]) {
                result[a[l]] += countRight;
                tmp[count++] = a[l++];
            }
            else {
                ++countRight;
                tmp[count++] = a[r++];
            }
        }
        while (l <= mid) {
            result[a[l]] += countRight;
            tmp[count++] = a[l++];
        }
        while (r <= end) tmp[count++] = a[r++];
        for (int i = 0; i < count; ++i) a[start + i] = tmp[i];
    }
}

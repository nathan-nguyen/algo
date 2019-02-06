class Solution {
    public int lengthOfLIS(int[] a) {
        if (a.length == 0) return 0;
        int n = a.length;

        List<Integer> list = new ArrayList<>();
        list.add(a[0]);

        for (int i = 1; i < n; ++i) {
            int index = Collections.binarySearch(list, a[i]);
            if (index < 0) index = -index - 1;
            if (index < list.size()) list.set(index, a[i]);
            else list.add(a[i]);
        }
        return list.size();     
    }
}

class Solution {
    public int longestOnes(int[] a, int k) {
        int start = 0, end = 0;
        int max = 0;
        int count = 0;
        while (end < a.length) {
            if (a[end] == 0) ++count;
            while (count > k && start <= end) {
                max = Math.max(max, end - start);
                if (a[start] == 0) --count;
                ++start;
            }
            ++end;
        }
        max = Math.max(max, end - start);
        return max;
    }
}


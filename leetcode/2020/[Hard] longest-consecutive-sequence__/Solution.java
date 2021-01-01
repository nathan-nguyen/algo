class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int k: nums) set.add(k);

        for (int k: nums) {
            int count = 0;
            for (int i = k; i <= Integer.MAX_VALUE && set.contains(i); ++i) {
                set.remove(i);
                ++count;
            }
            for (int i = k - 1; i >= Integer.MIN_VALUE && set.contains(i); --i) {
                set.remove(i);
                ++count;
            }
            max = Math.max(max, count);
        }
        return max;    
    }
}

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] map = new int[256];
        int start = 0, count = 0, max = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (++map[s.charAt(i)] == 1) ++count;
            while (count > k) {
                if (--map[s.charAt(start++)] == 0) --count;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}

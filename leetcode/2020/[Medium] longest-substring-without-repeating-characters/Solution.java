class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[256];
        int start = 0, max = 0;
        for (int i = 0; i < s.length(); ++i) {
            int c = s.charAt(i);
            ++count[c];
            while (count[c] > 1) --count[s.charAt(start++)];
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}

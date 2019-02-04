class Solution {
    public int longestSubstring(String s, int k) {
        int max = 0;
        for (int l = 1; l < 27; ++l) {
            int begin = 0, count = 0;
            int[] c = new int[26];
            for (int i = 0; i < s.length(); ++i) {
                int index = s.charAt(i) - 'a';
                if (++c[index] == 1) ++count;
                while (count > l) {
                    if (--c[s.charAt(begin) - 'a'] == 0) --count;
                    ++begin;
                }
                if (i - begin + 1 >= k && verify(c, k)) max = Math.max(max, i - begin + 1);
            }
            if (s.length() - begin >= k && verify(c, k)) max = Math.max(max, s.length() - begin);
        }
        return max;
    }

    private boolean verify(int[] c, int k) {
        for (int i = 0; i < 26; ++i) {
            if (c[i] > 0 && c[i] < k) return false;
        }
        return true;
    }
}

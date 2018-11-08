class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return new String();
        int start = 0, length = 0;
        for (int i = 0; i < s.length(); ++i) {
            int result = getPalindrome(s, i, i);
            if (result > length) {
                start = i - result / 2;
                length = result;
            }
            result = getPalindrome(s, i, i+1);
            if (result > length) {
                start = i - result / 2 + 1;
                length = result;
            }
        }
        return s.substring(start, start + length);
    }

    private int getPalindrome(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) != s.charAt(end)) break;
            --start;
            ++end;
        }
        return end - start - 1;
    }
}
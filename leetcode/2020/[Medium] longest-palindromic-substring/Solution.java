class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        int n = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < n; ++i) {
            for (int x = 0; i - x >= 0 && i + x < n; ++x) {
                if (s.charAt(i - x) == s.charAt(i + x)) {
                    if (2 * x > end - start) {
                        start = i - x;
                        end = i + x;
                    }
                }
                else break;
            }
            for (int x = 0; i - x >= 0 && i + 1 + x < n; ++x) {
                if (s.charAt(i - x) == s.charAt(i + 1 + x)) {
                    if (2 * x + 1 > end - start) {
                        start = i - x;
                        end = i + x + 1;
                    }
                }
                else break;
            }
        }
        return s.substring(start, end + 1);
    }
}

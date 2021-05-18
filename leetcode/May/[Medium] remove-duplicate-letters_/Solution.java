class Solution {
    // For each smallest character in string, find suffix starting with that character but contains all other distict characters
    // Recursive run founded suffix, but remove first character
    public String removeDuplicateLetters(String s) {
        if (s.length() <= 1) return s;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++i) ++count[s.charAt(i) - 'a'];

        int pos = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--count[s.charAt(i) - 'a'] == 0) break;
        }

        String suffix = removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
        return s.charAt(pos) + suffix;
    }
}

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] w = new int[26];

        for (int i = 0; i < order.length(); ++i) w[order.charAt(i) - 'a'] = i;

        for (int i = 1; i < words.length; ++i) {
            if (compare(words[i-1], words[i], w)) return false;
        }
        return true;
    }

    // Return true if s1 > s2
    private boolean compare(String s1, String s2, int[] w) {
        for (int i = 0; i < Math.min(s1.length(), s2.length()); ++i) {
            int c1 = s1.charAt(i) - 'a';
            int c2 = s2.charAt(i) - 'a';

            if (w[c1] == w[c2]) continue;
            return w[c1] > w[c2]; 
        }
        return s1.length() > s2.length();
    }
}

class Solution {
    public int longestDecomposition(String s) {
        int n = s.length();
        if (n == 0) return 0;
        if (n == 1) return 1;

        for (int i = 1; i * 2 <= n; ++i) {
            if (s.substring(0, i).equals(s.substring(n - i))) {
                return 2 + longestDecomposition(s.substring(i, n - i));
            }
        }
        return 1;
    }
}

class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        int[] a = new int[n+1];
        for (int i = 1; i <= s.length(); ++i) {
            a[i] = a[i-1] ^ (1 << (s.charAt(i - 1) - 'a'));
        }

        for (int[] q: queries) {
            int count = 0;
            int value = a[q[1] + 1] ^ a[q[0]];
            for (int i = 0; i < 26; ++i) count += (value >> i) & 1;
            result.add(count <= 2 * q[2] + 1);
        }

        return result;
    }
}
